package br.com.riot.api.service;

import br.com.riot.api.client.MatchClient;
import br.com.riot.api.dto.MatchDTO;
import br.com.riot.api.dto.MatchIdResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {

    @Autowired
    private MatchClient matchClient;

    public List<String> getMatchIdsFromPuuid(String puuid) {
        return matchClient.getMatchIDsFromPuuid(puuid);
    }

    public MatchDTO getMatchDataFromId(String matchId) {
        return matchClient.getMatchDataById(matchId);
    }
}
