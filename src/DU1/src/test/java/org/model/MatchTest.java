package org.model;

import org.example.model.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class MatchTest {
    @Test
    void getScores() {
        List<Team> teams = new ArrayList<>();
        Team team1 = new Team("Slavia");
        Team team2 = new Team("Sparta");
        Team team3 = new Team("Plzen");
        Team team4 = new Team("Bohemians");

        teams.add(team1);
        teams.add(team2);
        teams.add(team3);
        teams.add(team4);

        Championship champ = new Championship(teams);
        champ.simulateChampionship();

        assertNotNull(champ.getChampion());
    }
}
