package br.com.riot.api.service;

import br.com.riot.api.client.MatchClient;
import br.com.riot.api.entity.Match;
import br.com.riot.api.entity.Player;
import org.apache.catalina.util.RateLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MatchService {

    @Autowired
    private MatchClient matchClient;

    @Value("${api.match.queue}")
    private int queue;

    public List<Match> getMatchesById(@RequestBody Player player) throws InterruptedException {

        Thread.sleep(10000);
        List<String> matchIds = matchClient.getAllMatchesByPlayerUUID(
                player.getPuuid(),
                queue,
                0,
                100
        );

        List<Match> matches = new ArrayList<>();
        for(String id : matchIds) {
            matches.add(matchClient.getMatchById(id));
            Thread.sleep(2000);
        }

        return matches;
    }
}
