package org.example.model;
import java.time.ZonedDateTime;

public class matchEvent {
    enum Event{ START, END, GOAL, PENALTY, YELLOWCARD}

    private int gameTime;
    private Event event;
    private ZonedDateTime nowTime;

    public matchEvent(int gameTime, Event event, ZonedDateTime nowTime) {
        this.gameTime = gameTime;
        this.event = event;
        this.nowTime = nowTime;
    }

    public int getGameTime() {
        return gameTime;
    }

    public Event getEvent() {
        return event;
    }

    public ZonedDateTime getNowTime() {
        return nowTime;
    }
}
