package ixrk.planetside2.kdratio.character;

import org.springframework.stereotype.Service;
import retrofit2.Retrofit;
import retrofit2.adapter.java8.Java8CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class CharactersStatService {

    private final String baseUrl = "census.daybreakgames.com/s:example/get/ps2:v2/";

    public CharactersStatDTO kdStats(String characterName) {
        return null;
    }

    private Map<String, String> statsByCharacterName(String characterName) {
        CharacterResult characterResult = fetchCharacter(characterName.toLowerCase());
        if (characterResult.getReturned() != 1) {
            throw new RuntimeException("DayBreak Census API error");
        }

        Character character = characterResult.getCharacterList().get(0);
        Map<String, CharactersStatHistory> statHistories = parseStats(character);
        
//        Map<String, String> stats = statHistories.values().stream()
//                .map(this::reduceTimePeriods)
//                .flatMap(stats -> )
        return null;
    }

    private CharactersStatHistoryReduced reduceTimePeriods(CharactersStatHistory statHistory) {
        Day day = statHistory.getDay();
        int sum = 0;
        sum += Integer.parseInt(day.getD01());
        sum += Integer.parseInt(day.getD02());
        sum += Integer.parseInt(day.getD03());
        sum += Integer.parseInt(day.getD04());
        sum += Integer.parseInt(day.getD05());
        sum += Integer.parseInt(day.getD06());
        sum += Integer.parseInt(day.getD07());
        sum += Integer.parseInt(day.getD08());
        sum += Integer.parseInt(day.getD09());
        sum += Integer.parseInt(day.getD10());
        sum += Integer.parseInt(day.getD11());
        sum += Integer.parseInt(day.getD12());
        sum += Integer.parseInt(day.getD13());
        sum += Integer.parseInt(day.getD14());
        sum += Integer.parseInt(day.getD15());
        sum += Integer.parseInt(day.getD16());
        sum += Integer.parseInt(day.getD17());
        sum += Integer.parseInt(day.getD18());
        sum += Integer.parseInt(day.getD19());
        sum += Integer.parseInt(day.getD20());
        sum += Integer.parseInt(day.getD21());
        sum += Integer.parseInt(day.getD22());
        sum += Integer.parseInt(day.getD23());
        sum += Integer.parseInt(day.getD24());
        sum += Integer.parseInt(day.getD25());
        sum += Integer.parseInt(day.getD26());
        sum += Integer.parseInt(day.getD27());
        sum += Integer.parseInt(day.getD28());
        sum += Integer.parseInt(day.getD29());
        sum += Integer.parseInt(day.getD30());

        CharactersStatHistoryReduced reduced = new CharactersStatHistoryReduced();
        reduced.setStatName(statHistory.getStatName());
        reduced.setAllTime(statHistory.getAllTime());
        reduced.setOneLifeMax(statHistory.getOneLifeMax());
        reduced.setThirtyDays(String.valueOf(sum));
        return reduced;
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

        CharactersStatMethods charactersStatMethods = retrofit.create(CharactersStatMethods.class);

        return charactersStatMethods.byCharacterNameLowerCase(characterNameLowerCase).join();
    }
}
