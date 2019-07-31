package ixrk.planetside2.kdratio.character;

import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.concurrent.CompletableFuture;

public interface CensusApi {
    @GET("character/?c:join=characters_stat_history^inject_at:characters_stat_history^list:1&c:hide=times,certs,battle_rank,daily_ribbon,faction_id,head_id,title_id,profile_id,prestige_level")
    CompletableFuture<CharacterResult> byCharacterNameLowerCase(
            @Query("name.first_lower") String characterName
    );
}
