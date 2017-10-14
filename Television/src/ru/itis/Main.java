package ru.itis;

import java.util.concurrent.CopyOnWriteArrayList;

public class Main {

    public static void main(String[] args) {
        Console pult = Console.builder()
                .firm("SONY")
                .manufacturer("Japan")
                .name("RM-777")
                .serialNumber("RX666777")
                .termOfService("5 years")
                .build();
        Television tvSet = Television.getTelevision();
        Channel channel1 = new Channel("2x2");
        Channel channel2 = new Channel("Netflix");
        Channel channel3 = new Channel("HBO");
        Channel channel4 = new Channel("Disney");
        Channel channel5 = new Channel("Первый канал");
        Channel channel6 = new Channel("Россия24");
        Channel channel7 = new Channel("NationalGeographic");
        Channel channel8 = new Channel("CTC");
        Channel channel9 = new Channel("THT");
        Channel channel10 = new Channel("Something");
        tvSet.addChannel(channel1);
        tvSet.addChannel(channel2);
        tvSet.addChannel(channel3);
        tvSet.addChannel(channel4);
        tvSet.addChannel(channel5);
        tvSet.addChannel(channel6);
        tvSet.addChannel(channel7);
        tvSet.addChannel(channel8);
        tvSet.addChannel(channel9);
        tvSet.addChannel(channel10);
        pult.changeChannel(tvSet, channel1);
        pult.changeChannel(tvSet, channel1);
        pult.changeChannel(tvSet, channel2);
    }
}
