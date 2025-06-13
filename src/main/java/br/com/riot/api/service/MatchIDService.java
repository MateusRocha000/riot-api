package br.com.riot.api.service;

import br.com.riot.api.client.MatchIDClient;
import br.com.riot.api.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class MatchIDService {

    @Autowired
    private MatchIDClient matchIDClient;

    @Value("${api.match.queue}")
    private int queue;

    public List<String> getMatches (@RequestBody Player player) {
        return matchIDClient.getAllMatchesByPlayerUUID(player.getPuuid(), queue, 0, 100);
    }
}
