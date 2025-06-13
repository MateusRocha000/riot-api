package br.com.riot.api.controller;

import br.com.riot.api.entity.Player;
import br.com.riot.api.service.MatchIDService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/lol/match/v5")
public class MatchIDController {

    @Autowired
    private MatchIDService matchIDService;

    //@PostMapping(path = "/matches/by-puuid")
    public ResponseEntity<List<String>> getPlayerMatchIDs(@Valid @RequestBody Player player) {
        return ResponseEntity.ok().body(matchIDService.getMatches(player));
    }
}
