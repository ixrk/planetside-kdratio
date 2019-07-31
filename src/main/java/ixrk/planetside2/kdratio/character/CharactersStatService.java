package ixrk.planetside2.kdratio.character;

import org.springframework.stereotype.Service;
import retrofit2.Retrofit;
import retrofit2.adapter.java8.Java8CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CharactersStatService {

    private final String baseUrl = "http://census.daybreakgames.com/s:example/get/ps2:v2/";

    public CharactersStatDTO kdStats(String characterName) {
        Map<String, Integer> allStats = statsByCharacterName(characterName);
        Map<String, Integer> kdStatsMap = allStats.entrySet().stream()
                .filter(v -> v.getKey().startsWith("kills") || v.getKey().startsWith("deaths"))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        Map<String, String> resultMap = new LinkedHashMap<>();
        resultMap.put("All Time K/D", String.format("%.3f", calculateRatio(kdStatsMap.get("killsAllTime"), kdStatsMap.get("deathsAllTime"))));
        resultMap.put("One Life Max K/D", String.format("%.3f", calculateRatio(kdStatsMap.get("killsOneLifeMax"), kdStatsMap.get("deathsOneLifeMax"))));
        resultMap.put("Last 30 Days K/D", String.format("%.3f", calculateRatio(kdStatsMap.get("killsLast30Days"), kdStatsMap.get("deathsLast30Days"))));

        return new CharactersStatDTO(resultMap);
    }

    private double calculateRatio(int a, int b) {
        BigDecimal result = new BigDecimal(1);
        try {
            result = result.multiply(BigDecimal.valueOf(a));
            result = result.divide(BigDecimal.valueOf(b), 3, RoundingMode.HALF_UP);
        } catch (ArithmeticException e) {
            result = BigDecimal.valueOf(a);
        }
        return result.doubleValue();
    }

    private Map<String, Integer> statsByCharacterName(String characterName) {
        CharacterResult characterResult = fetchCharacter(characterName.toLowerCase());
        if (characterResult.getReturned() != 1) {
            throw new InvalidCharacterNameException();
        }

        Character character = characterResult.getCharacterList().get(0);
        Map<String, CharactersStatHistory> statHistories = parseStats(character);

        return statHistories.values().stream()
                .flatMap(v -> {
                    Map<String, Integer> map = new LinkedHashMap<>();
                    map.put(v.getStatName() + "AllTime", Integer.valueOf(v.getAllTime()));
                    map.put(v.getStatName() + "OneLifeMax", Integer.valueOf(v.getOneLifeMax()));
                    map.put(v.getStatName() + "Last30Days", reduceDays(v.getDay()));
                    return map.entrySet().stream();
                })
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private int reduceDays(Map<String, Integer> days) {
        return days.values().stream()
                .limit(30)
                .mapToInt(v -> v)
                .sum();
    }

    private Map<String, CharactersStatHistory> parseStats(Character character) {
        return character.getCharactersStatHistory().stream()
                .collect(Collectors.toMap(CharactersStatHistory::getStatName, v -> v));
    }

    private CharacterResult fetchCharacter(String characterNameLowerCase) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(Java8CallAdapterFactory.create())
                .build();

        CensusApi censusApi = retrofit.create(CensusApi.class);

        return censusApi.byCharacterNameLowerCase(characterNameLowerCase).join();
    }
}
