package ixrk.planetside2.kdratio.character;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class CharacterResult {

    @SerializedName("character_list")
    @Expose
    private List<Character> characterList = null;
    @SerializedName("returned")
    @Expose
    private Integer returned;

}