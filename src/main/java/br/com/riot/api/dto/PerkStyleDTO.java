package br.com.riot.api.dto;

import java.util.List;

public record PerkStyleDTO (
        String description,
        int style,
        List<PerkStyleSelectionDTO> selections
) {
}
