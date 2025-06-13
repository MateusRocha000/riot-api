package br.com.riot.api.entity;

import br.com.riot.api.entity.match.Info;
import br.com.riot.api.entity.match.Metadata;
import lombok.Data;

import java.util.List;

@Data
public class Match {

    public Metadata metadata;
    public Info info;

}
