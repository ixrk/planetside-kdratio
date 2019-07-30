
package ixrk.planetside2.kdratio.character;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class Name {

    @SerializedName("first")
    @Expose
    private String first;
    @SerializedName("first_lower")
    @Expose
    private String firstLower;

}