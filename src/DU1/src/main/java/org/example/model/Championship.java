package org.example.model;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Collections;

public class Championship {
    private List<Match> matches = new ArrayList<>();
    private List<Team> teams;
    private int rand, min;
    private Match activeMatch;
    Random rnd = new Random();

    public Championship(List<Team> teams) {
        this.teams = teams;
        generateMatches();
    }

    public void generateMatches()
    {
        Collections.shuffle(teams);
        if(teams.size() > 2)
        {
            for (int i = 0; i < teams.size() - 1; i++) {
                for (int j = i + 1; j < teams.size(); j++) {
                    matches.add(new Match(teams.get(i), teams.get(j)));
                }
            }
        }
        else throw new IllegalStateException("Není založen dostatek týmů");
    }
    public void simulateChampionship()
    {
        for (Match match : matches) {
            activeMatch = match;
            activeMatch.startGame();
            generateEvents(activeMatch.getTeam1());
            generateEvents(activeMatch.getTeam2());
            activeMatch.endGame();
            activeMatch.eventLog();
        }
    }
    public void generateEvents(Team team)
    {
        for (int i = 0; i < 4; i++)
        {
            rand = rnd.nextInt(10);
            min = rnd.nextInt(90);
            if (rand == 9 )
            {
                activeMatch.add(MatchEvent.EventType.PENALTY, min, team);
                int penalta = rnd.nextInt(2);
                if (penalta == 1) activeMatch.add(MatchEvent.EventType.GOAL, min, team);
                else activeMatch.add(MatchEvent.EventType.MISSEDPENALTY, min, team);
                break;
            }
            if (rand > 6 ) activeMatch.add(MatchEvent.EventType.GOAL, min, team);
        }
    }
}
