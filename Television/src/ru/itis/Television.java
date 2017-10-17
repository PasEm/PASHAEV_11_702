package ru.itis;

import java.time.LocalTime;

public class Television {
    private static final Television instance;
    public static final int channelCount = 10;
    private int currentCount = 0;
    Channel[] tvChannel = new Channel[channelCount];
    private Television(){

    }
    static{
        instance = new Television();
    }
    public  static  Television getTelevision(){
        return instance;
    }
    public void log(String channel, String broadcast){
        System.out.println("At channel " + channel + " is translating broadcast " + broadcast + " at " + LocalTime.now());
    }
    public void addChannel(Channel channel){
        tvChannel[currentCount] = channel;
        currentCount++;
    }
}
