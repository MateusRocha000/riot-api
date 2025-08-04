package br.com.riot.api.client;

import br.com.riot.api.config.RiotClientConfig;
import br.com.riot.api.dto.match.MatchIDsResponseDTO;
import br.com.riot.api.dto.match.MatchResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "${riot.api.match.base-url}", name = "riot-matches", configuration = RiotClientConfig.class)
public interface MatchClient {

    @GetMapping(path = "/by-puuid/{puuid}/ids")
    MatchIDsResponseDTO listAllIdsByPuuid(@PathVariable String puuid);

    @GetMapping(path = "{matchId}")
    MatchResponseDTO getMatchById(@PathVariable String matchId);
}
