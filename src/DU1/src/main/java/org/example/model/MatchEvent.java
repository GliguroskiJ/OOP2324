package org.example.model;

public class MatchEvent {
    enum EventType{ START, END, GOAL, PENALTY, MISSEDPENALTY}
    private int gameTime;
    private EventType eventtype;
    private Team team;

    public MatchEvent(int gameTime, EventType eventtype, Team team) {
        this.gameTime = gameTime;
        this.eventtype = eventtype;
        this.team = team;
    }

    public MatchEvent(int gameTime, EventType eventtype) {
        this.gameTime = gameTime;
        this.eventtype = eventtype;
        this.team = null;
    }

    public int getGameTime() {
        return gameTime;
    }

    public EventType getEventtype() {
        return eventtype;
    }

    public Team getTeam() {
        return team;
    }
}
