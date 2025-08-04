package br.com.riot.api.controller;

import br.com.riot.api.dto.MatchDTO;
import br.com.riot.api.dto.MatchIdRequestDTO;
import br.com.riot.api.dto.MatchIdResponseDTO;
import br.com.riot.api.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matches")
public class MatchController {

    @Autowired
    private MatchService matchService;

    @GetMapping("/by-puuid/{puuid}")
    public ResponseEntity<List<String>> getMatchIds(@PathVariable String puuid) {
        return ResponseEntity.ok(matchService.getMatchIdsFromPuuid(puuid));
    }

    @GetMapping("/{matchId}")
    public ResponseEntity<MatchDTO> getMatchData(@PathVariable String matchId) {
        return ResponseEntity.ok(matchService.getMatchDataFromId(matchId));
    }
}
