package br.com.riot.api.entity.match;

import lombok.Data;

import java.util.List;

@Data
public class Info {

    public int queueId;
    public int gameDuration;
    public List<Participant> participants;


}
