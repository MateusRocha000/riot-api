package br.com.riot.api;

import br.com.riot.api.dto.account.AccountResponseDTO;
import br.com.riot.api.dto.match.MatchIDsResponseDTO;
import br.com.riot.api.model.Player;
import br.com.riot.api.service.account.AccountService;
import br.com.riot.api.service.csv.CSVExportService;
import br.com.riot.api.service.match.MatchIDService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ApiApplicationTests {

	@Autowired
	private AccountService accountService;

	@Autowired
	private MatchIDService matchIDService;

	@Autowired
	private CSVExportService csvExportService;

	@Test
	void shouldGetNickAndTag() {
		Player player = TestMocks.newPlayer();
		AccountResponseDTO dto = accountService.listAccountByPuuid(player.getPuuid());
		assertEquals(player.getGameName(), dto.gameName());
		assertEquals(player.getTagLine(), dto.tagLine());
	}
}
