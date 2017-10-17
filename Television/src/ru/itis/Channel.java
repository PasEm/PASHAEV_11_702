package ru.itis;

public class Channel {
    public static final int broadcastCount = 4;
    Broadcast[] tvBroadcast = new Broadcast[broadcastCount];
    private String name;
    private int count = 0;
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public Channel(String name){
        setName(name);
    }
    public void addBroadcast(Broadcast broadcast){
        tvBroadcast[count] = broadcast;
        count++;
    }
}
