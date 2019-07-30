package ixrk.planetside2.kdratio.character;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class Character {

    @SerializedName("character_id")
    @Expose
    private String characterId;
    @SerializedName("name")
    @Expose
    private Name name;
    @SerializedName("characters_stat_history")
    @Expose
    private List<CharactersStatHistory> charactersStatHistory = null;

}