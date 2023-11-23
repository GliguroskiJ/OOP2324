package org.example.model;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Match {
    private Team team1;
    private Team team2;
    private List<MatchEvent> eventList = new ArrayList<>();
    private boolean gameStarted = false;
    private boolean gameEnded = false;
    public Match(Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
    }
    public boolean isGameStarted() {
        return gameStarted;
    }

    public boolean isGameEnded() {
        return gameEnded;
    }

    public void startGame()
    {
        if (gameStarted) throw new IllegalStateException("Zápas již byl zahájen");
        gameStarted = true;
        eventList.addFirst(new MatchEvent(0, MatchEvent.EventType.START));
    }
    public void endGame()
    {
        Random rand = new Random();
        int minutesPlus = rand.nextInt(3);
        if (!gameStarted) throw new IllegalStateException("Zápas ještě nezačal");
        gameEnded = true;
        eventList.addLast(new MatchEvent(90+minutesPlus, MatchEvent.EventType.END));
    }
    public void add(MatchEvent.EventType evntp, int gametime, Team team) {
        eventList.add(new MatchEvent(gametime, evntp, team));
    }
    public void eventLog()
    {
        eventList.sort(Comparator.comparing(MatchEvent::getGameTime));
        System.out.println("\nZápas "+team1.getTeamName()+" proti "+team2.getTeamName());
        for (int i = 0; i < eventList.size(); i++)
        {
            if (eventList.get(i).getEventtype() == MatchEvent.EventType.START || eventList.get(i).getEventtype() == MatchEvent.EventType.END)
            {
                System.out.println("Údálost: "+eventList.get(i).getEventtype()+" v "+eventList.get(i).getGameTime()+" minutě");
            }
            else System.out.println("Údálost: "+eventList.get(i).getEventtype()+" v "+eventList.get(i).getGameTime()+" minutě pro tým "+eventList.get(i).getTeam().getTeamName());
        }
        System.out.println(getWinner());
        eventList.clear();
    }
    public Team getTeam1() {
        return team1;
    }
    public Team getTeam2() {
        return team2;
    }
    public String getWinner()
    {
        if (isGameStarted() && isGameEnded())
        {
            int scoreTeam1 = 0;
            int scoreTeam2 = 0;
            for (int i = 0; i < eventList.size(); i++)
            {
                if (eventList.get(i).getEventtype() == MatchEvent.EventType.GOAL)
                {
                    if (eventList.get(i).getTeam() == team1) scoreTeam1++;
                    else scoreTeam2++;
                }
            }
            if (scoreTeam1 > scoreTeam2) getTeam1().setPoints(1);
            else getTeam2().setPoints(1);
            return "Zápas skončil "+getTeam1().getTeamName()+" "+scoreTeam1+":"+scoreTeam2+" "+getTeam2().getTeamName();
        }
        else
        {
            return "Zápas neskočil či ještě nezačal.";
        }
    }
}
