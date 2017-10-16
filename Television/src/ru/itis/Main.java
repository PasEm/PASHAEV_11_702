package ru.itis;

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
        tvSet.addChannel(new Channel("2x2"));
        tvSet.tvChannel[0].addBroadcast(new Broadcast("That", 0, 21600));
        tvSet.tvChannel[1].addBroadcast(new Broadcast("Is", 21601, 43200));
        tvSet.tvChannel[2].addBroadcast(new Broadcast("This", 43201, 64800));
        tvSet.tvChannel[3].addBroadcast(new Broadcast("AAAAAAA", 64801, 86400));
        tvSet.addChannel(new Channel("Netflix"));
        tvSet.tvChannel[0].addBroadcast(new Broadcast("That", 0, 21600));
        tvSet.tvChannel[1].addBroadcast(new Broadcast("Is", 21601, 43200));
        tvSet.tvChannel[2].addBroadcast(new Broadcast("This", 43201, 64800));
        tvSet.tvChannel[3].addBroadcast(new Broadcast("AAAAAAA", 64801, 86400));
        tvSet.addChannel(new Channel("HBO"));
        tvSet.tvChannel[0].addBroadcast(new Broadcast("That", 0, 21600));
        tvSet.tvChannel[1].addBroadcast(new Broadcast("Is", 21601, 43200));
        tvSet.tvChannel[2].addBroadcast(new Broadcast("This", 43201, 64800));
        tvSet.tvChannel[3].addBroadcast(new Broadcast("AAAAAAA", 64801, 86400));
        tvSet.addChannel(new Channel("Disney"));
        tvSet.tvChannel[0].addBroadcast(new Broadcast("That", 0, 21600));
        tvSet.tvChannel[1].addBroadcast(new Broadcast("Is", 21601, 43200));
        tvSet.tvChannel[2].addBroadcast(new Broadcast("This", 43201, 64800));
        tvSet.tvChannel[3].addBroadcast(new Broadcast("AAAAAAA", 64801, 86400));
        tvSet.addChannel(new Channel("Первый канал"));
        tvSet.tvChannel[0].addBroadcast(new Broadcast("That", 0, 21600));
        tvSet.tvChannel[1].addBroadcast(new Broadcast("Is", 21601, 43200));
        tvSet.tvChannel[2].addBroadcast(new Broadcast("This", 43201, 64800));
        tvSet.tvChannel[3].addBroadcast(new Broadcast("AAAAAAA", 64801, 86400));
        tvSet.addChannel(new Channel("Россия24"));
        tvSet.tvChannel[0].addBroadcast(new Broadcast("That", 0, 21600));
        tvSet.tvChannel[1].addBroadcast(new Broadcast("Is", 21601, 43200));
        tvSet.tvChannel[2].addBroadcast(new Broadcast("This", 43201, 64800));
        tvSet.tvChannel[3].addBroadcast(new Broadcast("AAAAAAA", 64801, 86400));
        tvSet.addChannel(new Channel("NationalGeographic"));
        tvSet.tvChannel[0].addBroadcast(new Broadcast("That", 0, 21600));
        tvSet.tvChannel[1].addBroadcast(new Broadcast("Is", 21601, 43200));
        tvSet.tvChannel[2].addBroadcast(new Broadcast("This", 43201, 64800));
        tvSet.tvChannel[3].addBroadcast(new Broadcast("AAAAAAA", 64801, 86400));
        tvSet.addChannel(new Channel("CTC"));
        tvSet.tvChannel[0].addBroadcast(new Broadcast("That", 0, 21600));
        tvSet.tvChannel[1].addBroadcast(new Broadcast("Is", 21601, 43200));
        tvSet.tvChannel[2].addBroadcast(new Broadcast("This", 43201, 64800));
        tvSet.tvChannel[3].addBroadcast(new Broadcast("AAAAAAA", 64801, 86400));
        tvSet.addChannel(new Channel("THT"));
        tvSet.tvChannel[0].addBroadcast(new Broadcast("That", 0, 21600));
        tvSet.tvChannel[1].addBroadcast(new Broadcast("Is", 21601, 43200));
        tvSet.tvChannel[2].addBroadcast(new Broadcast("This", 43201, 64800));
        tvSet.tvChannel[3].addBroadcast(new Broadcast("AAAAAAA", 64801, 86400));
        tvSet.addChannel(new Channel("Something"));
        tvSet.tvChannel[0].addBroadcast(new Broadcast("That", 0, 21600));
        tvSet.tvChannel[1].addBroadcast(new Broadcast("Is", 21601, 43200));
        tvSet.tvChannel[2].addBroadcast(new Broadcast("This", 43201, 64800));
        tvSet.tvChannel[3].addBroadcast(new Broadcast("AAAAAAA", 64801, 86400));
        pult.changeChannel(tvSet, tvSet.tvChannel[0]);
        pult.changeChannel(tvSet, tvSet.tvChannel[7]);
        pult.changeChannel(tvSet, tvSet.tvChannel[5]);
    }
}
