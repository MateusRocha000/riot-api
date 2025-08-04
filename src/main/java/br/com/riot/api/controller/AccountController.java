package br.com.riot.api.controller;

import br.com.riot.api.dto.AccountResponseDTO;
import br.com.riot.api.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/{puuid}")
    public ResponseEntity<AccountResponseDTO> getAccountByPuuid(@PathVariable String puuid) {
        return ResponseEntity.ok(accountService.getNickTagByPuuid(puuid));
    }

    @GetMapping("/{gameName}/{tagLine}")
    public ResponseEntity<AccountResponseDTO> getAccountByNickTag(@PathVariable String gameName, @PathVariable String tagLine) {
        return ResponseEntity.ok(accountService.getPlayerByNickTag(gameName, tagLine));
    }
}
