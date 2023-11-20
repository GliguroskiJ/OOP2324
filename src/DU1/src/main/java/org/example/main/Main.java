package org.example.main;
import java.util.ArrayList;
import java.util.List;
import org.example.model.Championship;
import org.example.model.Team;

public class Main {
    public static void main(String[] args) {
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
    }
}