package br.com.riot.api.service.match;

import br.com.riot.api.client.MatchClient;
import br.com.riot.api.dto.match.MatchIDsResponseDTO;
import br.com.riot.api.dto.match.MatchResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchIDService {

    @Autowired
    private MatchClient matchClient;

    public MatchIDsResponseDTO listMatchIDs(String puuid) {
        return matchClient.listAllIdsByPuuid(puuid);
    }

    public MatchResponseDTO getMatchDataFromId(String matchId) {
        return matchClient.getMatchById(matchId);
    }
}
