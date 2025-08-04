package br.com.riot.api.dto.match;

import java.util.List;

public record MatchIDsResponseDTO(
        List<String> ids
) {}
