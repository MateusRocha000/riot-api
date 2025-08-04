package br.com.riot.api.dto;

public record TeamDTO(
        int teamId,
        boolean win,
        ObjectivesDTO objectivesDTO
) {
}
