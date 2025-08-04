package br.com.riot.api.service.csv;

import br.com.riot.api.dto.account.AccountResponseDTO;
import br.com.riot.api.dto.match.MatchIDsResponseDTO;
import com.opencsv.CSVWriter;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

@Service
public class CSVExportService {

    public void exportAccount(List<AccountResponseDTO> accounts, String filePath) throws IOException {
        try (
                Writer writer = new FileWriter(filePath);
                CSVWriter csvWriter = new CSVWriter(writer)) {
            String[] header = {"PUUID", "Nickname", "TagLine"};
            csvWriter.writeNext(header);

            for (AccountResponseDTO accountResponseDTO : accounts) {
                String[] line = {
                        accountResponseDTO.puuid(),
                        accountResponseDTO.gameName(),
                        accountResponseDTO.tagLine()
                };
                csvWriter.writeNext(line);
            }
        }
    }

    public void exportIDs(MatchIDsResponseDTO ids, String filePath) throws IOException {
        try (
                Writer writer = new FileWriter(filePath);
                CSVWriter csvWriter = new CSVWriter(writer)) {
            String[] header = {"ID"};
            csvWriter.writeNext(header);

            for (String id : ids.ids()) {
                String[] line = {
                        id
                };
                csvWriter.writeNext(line);
            }
        }
    }
}
