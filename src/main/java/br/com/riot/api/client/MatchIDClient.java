package br.com.riot.api.client;

import br.com.riot.api.config.RiotFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(url = "${api.base.url}", name = "matchIdClient", configuration = RiotFeignConfig.class)
public interface MatchIDClient {

    @GetMapping(path = "/lol/match/v5/matches/by-puuid/{puuid}/ids")
    List<String> getAllMatchesByPlayerUUID(
            @PathVariable("puuid") String puuid,
            @RequestParam("queue") int queue,
            @RequestParam("start") int start,
            @RequestParam("count") int count
    );
}
