package ixrk.planetside2.kdratio.character;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class CharactersStatDTO {
    private String id;
    private String characterName;
    private int kills;
    private int deaths;
    private int killDeathRatio;
    private int killsInMonth;
    private int deathsInMonth;
    private int killDeathRatioInMonth;
}
