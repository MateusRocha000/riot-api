package br.com.riot.api.entity.match;


import lombok.Data;

@Data
public class Participant {

    public String win;
    public String position;
    public String champion;
    public int kaynTransformation;
    public int champLevel;
    public int kills;
    public int deaths;
    public int assists;
    public double kda;
    public double killParticipation;
    public String spellOne;
    public String spellTwo;
    public int earnedGold;
    public int spentGold;
    public int cs;
    public double goldPerMin;
    public double dmgPerMin;
    public int totalObjectives;
    public double objParticipation;
    public int dmgToChampions;
    public int dmgTaken;
    public int dmgHealed;
    public int dmgShielded;
    public int timeDead;
    public int visionScore;
    public int wardsPlaced;
    public int wardsKilled;
    public int visionWardsBought;
    public int visionWardsPlaced;
    public String item1;
    public String item2;
    public String item3;
    public String item4;
    public String item5;
    public String item6;
    public String trinket;
}
