package ru.itis;

import java.time.LocalTime;

public class Channel {
    private int broadcastCount = 4;
    Broadcast[] tvBroadcast = new Broadcast[broadcastCount];
    private String name;
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    Broadcast broadcast1 = new Broadcast("That", 0, 21600);
    Broadcast broadcast2 = new Broadcast("Is", 21601, 43200);
    Broadcast broadcast3 = new Broadcast("This", 43201, 64800);
    Broadcast broadcast4 = new Broadcast("AAAAAAA", 64801, 86400);
    public Channel(String name){
        tvBroadcast[0] = broadcast1;
        tvBroadcast[1] = broadcast2;
        tvBroadcast[2] = broadcast3;
        tvBroadcast[3] = broadcast4;
        setName(name);
    }
}
