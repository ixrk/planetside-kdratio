
package ixrk.planetside2.kdratio.character;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class CharactersStatHistoryResult {

    @SerializedName("characters_stat_history_list")
    @Expose
    private List<CharactersStatHistory> value = null;
    @SerializedName("returned")
    @Expose
    private Integer returned;

}
