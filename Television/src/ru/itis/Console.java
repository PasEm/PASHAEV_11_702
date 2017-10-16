package ru.itis;

import javafx.util.Builder;

import java.time.LocalTime;

public class Console {
    private String serialNumber;
    private String name;
    private String firm;
    private String manufacturer;
    private String termOfService;
    private Television tvSet = Television.getTelevision();
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
        private int channelCount;
        private int broadcastCount;
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
 /*   public String getSerialNumber(){
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
    } */
    public void changeChannel(String name){
        for (int i = 0; i < tvSet.channelCount; i++){
            if (tvSet.tvChannel[i].getName() == name) {
                for (int j = 0; j < tvSet.tvChannel[i].broadcastCount; j++) {
                    if (LocalTime.now().isBefore(tvSet.tvChannel[i].tvBroadcast[j].getFinishTime()) && LocalTime.now().isAfter(tvSet.tvChannel[i].tvBroadcast[j].getBeginTime())) {
                        Television.getTelevision().log(tvSet.tvChannel[i].getName(), tvSet.tvChannel[i].tvBroadcast[j].getBroadcastName());
                        break;
                    }
                }
            }
        }
    }
}
