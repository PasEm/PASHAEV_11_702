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
    public void setBeginTime(LocalTime time){
        this.beginTime = time;
    }
    public LocalTime getBeginTime() {
        return beginTime;
    }
    public void setFinishTime(LocalTime time){
        this.finishTime = time;
    }
    public LocalTime getFinishTime(){
        return this.finishTime;
    }
    public Broadcast(String broadcastName, LocalTime timeBegin, LocalTime timeFinish){
        setBroadcastName(broadcastName);
        setBeginTime(timeBegin);
        setFinishTime(timeFinish);
    }
}
