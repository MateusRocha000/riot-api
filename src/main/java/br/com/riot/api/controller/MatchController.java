package br.com.riot.api.controller;

import br.com.riot.api.entity.Match;
import br.com.riot.api.entity.Player;
import br.com.riot.api.service.MatchIDService;
import br.com.riot.api.service.MatchService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/lol/match/v5")
public class MatchController {

    @Autowired
    private MatchService matchService;

    @PostMapping(path = "/matches/by-puuid")
    public ResponseEntity<List<Match>> getMatchData(@Valid @RequestBody Player player) throws InterruptedException {
        return ResponseEntity.ok().body(matchService.getMatchesById(player));
    }
}
