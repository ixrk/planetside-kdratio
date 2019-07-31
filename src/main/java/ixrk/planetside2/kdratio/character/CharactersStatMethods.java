package ixrk.planetside2.kdratio.character;

import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.concurrent.CompletableFuture;

public interface CharactersStatMethods {
    @GET("character")
    CompletableFuture<CharacterResult> byCharacterNameLowerCase(
            @Query("name.first_lower") String characterName
    );
}
