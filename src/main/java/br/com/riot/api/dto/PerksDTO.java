package br.com.riot.api.dto;

import java.util.List;

public record PerksDTO(
        PerkStatsDTO statPerks,
        List<PerkStyleDTO> styles
) {
}
