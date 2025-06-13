package br.com.riot.api.entity.match;

import lombok.Data;

import java.util.List;

@Data
public class Metadata {

    public String matchId;
    public List<String> participant;
}
