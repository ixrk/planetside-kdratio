
package ixrk.planetside2.kdratio.character;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.Map;

@Getter
public class CharactersStatHistory {

    @SerializedName("character_id")
    @Expose
    private String characterId;
    @SerializedName("stat_name")
    @Expose
    private String statName;
    @SerializedName("all_time")
    @Expose
    private String allTime;
    @SerializedName("one_life_max")
    @Expose
    private String oneLifeMax;
    @SerializedName("day")
    @Expose
    private Map<String, Integer> day;
    @SerializedName("month")
    @Expose
    private Map<String, Integer> month;
    @SerializedName("week")
    @Expose
    private Map<String, Integer> week;
    @SerializedName("last_save")
    @Expose
    private String lastSave;
    @SerializedName("last_save_date")
    @Expose
    private String lastSaveDate;

}
