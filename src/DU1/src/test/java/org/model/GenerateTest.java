package org.model;

import org.example.model.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class GenerateTest {
    Team team1 = new Team("Slavia");
    Team team2 = new Team("Sparta");
    Team team3 = new Team("Plzen");
    Team team4 = new Team("Bohemians");

    @Test
    void zeroTeams() {
        List<Team> teams = new ArrayList<>();
        Championship champ = new Championship(teams);

        assertThrows(IllegalStateException.class, champ::generateMatches);
    }

    @Test
    void oneTeam() {
        List<Team> teams = new ArrayList<>();
        Championship champ = new Championship(teams);

        teams.add(team1);

        assertThrows(IllegalStateException.class, champ::generateMatches);
    }

    @Test
    void fourTeams() {
        List<Team> teams = new ArrayList<>();
        Championship champ = new Championship(teams);

        teams.add(team1);
        teams.add(team2);
        teams.add(team3);
        teams.add(team4);

        assertEquals(4,teams.size());
    }
}
