package br.com.riot.api.controller.match;

import br.com.riot.api.dto.account.AccountResponseDTO;
import br.com.riot.api.dto.match.MatchIDsResponseDTO;
import br.com.riot.api.service.account.AccountService;
import br.com.riot.api.service.csv.CSVExportService;
import br.com.riot.api.service.match.MatchIDService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/match-ids")
public class MatchIDController {

    @Autowired
    private CSVExportService csvExportService;

    @Autowired
    private MatchIDService matchIDService;

    @Autowired
    private AccountService accountService;

    @GetMapping("/export-ids")
    private ResponseEntity<String> exportMatchIDs(@RequestBody @Valid String puuid) {
        MatchIDsResponseDTO dto = matchIDService.listMatchIDs(puuid);
        AccountResponseDTO accountResponseDTO = accountService.listAccountByPuuid(puuid);
        try {
            csvExportService.exportIDs(dto, accountResponseDTO.gameName() + "-IDs.csv");
            return ResponseEntity.ok("Exportado com sucesso");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: " + e.getMessage());
        }
    }
}
