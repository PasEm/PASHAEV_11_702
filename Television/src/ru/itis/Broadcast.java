package ru.itis;

import java.time.LocalTime;

public class Broadcast {
    private LocalTime beginTime;
    private LocalTime finishTime;
    private String broadcastName;
    public void setBroadcastName(String broadcastName) {
        this.broadcastName = broadcastName;
    }
    public String getBroadcastName() {
        return broadcastName;
    }
    public void setBeginTime(int time){
        this.beginTime = LocalTime.of((time / 3600) % 24, (time % 3600) / 60, time % 60);
    }
    public LocalTime getBeginTime() {
        return beginTime;
    }
    public void setFinishTime(int time){
        this.finishTime = LocalTime.of((time / 3600) % 24, (time % 3600) / 60, time % 60);
    }
    public LocalTime getFinishTime(){
        return this.finishTime;
    }
    public Broadcast(String broadcastName, int timeBegin, int timeFinish){
        setBroadcastName(broadcastName);
        setBeginTime(timeBegin);
        setFinishTime(timeFinish);
    }
}
