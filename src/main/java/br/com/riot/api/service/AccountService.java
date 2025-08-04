package br.com.riot.api.service;

import br.com.riot.api.client.AccountClient;
import br.com.riot.api.dto.AccountResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountClient accountClient;

    public AccountResponseDTO getNickTagByPuuid (String puuid) {
        return accountClient.getAccountByPuuid(puuid);
    }

    public AccountResponseDTO getPlayerByNickTag (String gameName, String tagLine) {
        return accountClient.getAccountByNickTag(gameName, tagLine);
    }
}
