package br.com.riot.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Player {

    String puuid;

    String gameName;

    String tagLine;
}
