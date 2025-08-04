package br.com.riot.api.client;

import br.com.riot.api.config.RiotClientConfig;
import br.com.riot.api.dto.account.AccountResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "${riot.api.account.base-url}", name = "riot-account", configuration = RiotClientConfig.class)
public interface AccountClient {

    @GetMapping(path = "/by-riot-id/{gameName}/{tagLine}?api_key={api_key}")
    AccountResponseDTO getAccount(@PathVariable String gameName, @PathVariable String tagLine, @PathVariable String apiKey);

    @GetMapping(path = "/by-puuid/{puuid}")
    AccountResponseDTO getAccountByPuuid(@PathVariable String puuid);
}
