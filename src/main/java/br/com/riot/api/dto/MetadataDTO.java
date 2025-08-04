package br.com.riot.api.dto;

import java.util.List;

public record MetadataDTO(
        String matchId,
        List<String> participants
) {
}
