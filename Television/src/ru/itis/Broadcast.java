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
    public void setBeginTime(LocalTime beginTime){
        this.beginTime = beginTime;
    }
    public LocalTime getBeginTime() {
        return beginTime;
    }
    public void setFinishTime(LocalTime finishTime){
        this.finishTime = finishTime;
    }
    public LocalTime getFinishTime(){
        return this.finishTime;
    }
    public Broadcast(String broadcastName, LocalTime beginTime, LocalTime finishTime){
        setBroadcastName(broadcastName);
        setBeginTime(beginTime);
        setFinishTime(finishTime);
    }
}
