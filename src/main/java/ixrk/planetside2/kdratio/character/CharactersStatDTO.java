package ixrk.planetside2.kdratio.character;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.Map;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class CharactersStatDTO {
    Map<String, String> map = new LinkedHashMap<>();
//    private String id;
//    private String characterName;
//    private int kills;
//    private int deaths;
//    private int killDeathRatio;
//    private int killsInMonth;
//    private int deathsInMonth;
//    private int killDeathRatioInMonth;
}
