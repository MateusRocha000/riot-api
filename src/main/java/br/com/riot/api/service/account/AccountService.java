package br.com.riot.api.service.account;

import br.com.riot.api.client.AccountClient;
import br.com.riot.api.dto.account.AccountResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class AccountService {

    @Autowired
    private AccountClient accountClient;

    public AccountResponseDTO listAccount(String nickname, String tagLine, String apiKey) {
        return accountClient.getAccount(nickname, tagLine, apiKey);
    }

    public AccountResponseDTO listAccountByPuuid(String puuid) {
        return accountClient.getAccountByPuuid(puuid);
    }
}
