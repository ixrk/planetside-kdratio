
package ixrk.planetside2.kdratio.character;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

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
    private Day day;
    @SerializedName("month")
    @Expose
    private Month month;
    @SerializedName("week")
    @Expose
    private Week week;
    @SerializedName("last_save")
    @Expose
    private String lastSave;
    @SerializedName("last_save_date")
    @Expose
    private String lastSaveDate;

}
