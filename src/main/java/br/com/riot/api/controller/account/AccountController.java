package br.com.riot.api.controller.account;

import br.com.riot.api.dto.account.AccountRequestDTO;
import br.com.riot.api.dto.account.AccountResponseDTO;
import br.com.riot.api.service.account.AccountService;
import br.com.riot.api.service.csv.CSVExportService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/account")
@Tag(name = "AccountController", description = "Controlador para informações de contas")
public class AccountController {

    @Autowired
    private CSVExportService csvExportService;

    @Autowired
    private AccountService accountService;

    @GetMapping("/export-account")
    public ResponseEntity<String> exportAccount(@RequestBody @Valid AccountRequestDTO requestDTO, @PathVariable String apiKey) {
        List<AccountResponseDTO> player = new ArrayList<>();

        AccountResponseDTO dto = accountService.listAccount(requestDTO.gameName(), requestDTO.tagLine(), apiKey);
        if (dto != null) player.add(dto);

        try {
            csvExportService.exportAccount(player, requestDTO.gameName() + ".csv");
            return ResponseEntity.ok("Exportado com sucesso");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: " + e.getMessage());
        }
    }
}
