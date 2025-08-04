package br.com.riot.api.client;

import br.com.riot.api.dto.MatchDTO;
import br.com.riot.api.dto.MatchIdResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(url = "${riot.api.match.base-url}", name = "match")
public interface MatchClient {

    @GetMapping("/by-puuid/{puuid}/ids")
    List<String> getMatchIDsFromPuuid(@PathVariable String puuid);

    @GetMapping("/{matchId}")
    MatchDTO getMatchDataById(@PathVariable String matchId);
}
