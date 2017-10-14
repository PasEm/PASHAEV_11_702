package ru.itis;

import javafx.util.Builder;

import java.time.LocalTime;

public class Console {
    private String serialNumber;
    private String name;
    private String firm;
    private String manufacturer;
    private String termOfService;
    private Television tvSet;
    private int channelCount = 10;
    private int broadcastCount = 4;
    public Console(Builder builder){
        this.serialNumber = builder.serialNumber;
        this.name = builder.name;
        this.firm = builder.firm;
        this.manufacturer = builder.manufacturer;
        this.termOfService = builder.termOfService;
    }
    public static Builder builder() {
        return new Builder();
    }
    public static class Builder{
        private String serialNumber;
        private String name;
        private String firm;
        private String manufacturer;
        private String termOfService;
        public Builder serialNumber(String serialNumber){
            this.serialNumber = serialNumber;
            return this;
        }
        public Builder name(String name){
            this.name = name;
            return this;
        }
        public Builder firm(String firm){
            this.firm = firm;
            return this;
        }
        public Builder manufacturer(String manufacturer){
            this.manufacturer = manufacturer;
            return this;
        }
        public Builder termOfService(String termOfService) {
            this.termOfService = termOfService;
            return this;
        }
        public Console build(){
            return new Console(this);
        }
    }
    public String getSerialNumber(){
        return serialNumber;
    }
    public String getFirm() {
        return firm;
    }
    public String getManufacturer() {
        return manufacturer;
    }
    public String getName(){
        return name;
    }
    public String getTermOfService() {
        return termOfService;
    }
    public void changeChannel(Television tvSet, Channel channel){
        for (int i = 0; i < channelCount; i++){
            if (tvSet.tvChannel[i] == channel) {
                for (int j = 0; j < broadcastCount; j++){
                    if (LocalTime.now().isBefore(channel.tvBroadcast[j].getBeginTime()) && LocalTime.now().isAfter(channel.tvBroadcast[j].getFinishTime())){
                        Television.getTelevision().log(tvSet.tvChannel[i].getName(), channel.tvBroadcast[j].getBroadcastName());
                    }
                }
            }
        }
    }
}
