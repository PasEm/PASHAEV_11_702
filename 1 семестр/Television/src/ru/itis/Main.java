package ru.itis;

import java.time.LocalTime;

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
        tvSet.tvChannel[0].addBroadcast(new Broadcast("Simpsons", LocalTime.parse("00:00:00"), LocalTime.parse("03:00:00")));
        tvSet.tvChannel[0].addBroadcast(new Broadcast("Griffins", LocalTime.parse("03:00:01"), LocalTime.parse("07:00:00")));
        tvSet.tvChannel[0].addBroadcast(new Broadcast("American Dad", LocalTime.parse("07:00:01"), LocalTime.parse("15:00:00")));
        tvSet.tvChannel[0].addBroadcast(new Broadcast("Something", LocalTime.parse("15:00:01"), LocalTime.parse("23:59:59")));
        tvSet.addChannel(new Channel("Netflix"));
        tvSet.tvChannel[1].addBroadcast(new Broadcast("Serial 1", LocalTime.parse("00:00:00"), LocalTime.parse("06:00:00")));
        tvSet.tvChannel[1].addBroadcast(new Broadcast("Serial 2", LocalTime.parse("06:00:01"), LocalTime.parse("12:00:00")));
        tvSet.tvChannel[1].addBroadcast(new Broadcast("Serial 3", LocalTime.parse("12:00:01"), LocalTime.parse("18:00:00")));
        tvSet.tvChannel[1].addBroadcast(new Broadcast("Serial 4", LocalTime.parse("18:00:01"), LocalTime.parse("23:59:59")));
        tvSet.addChannel(new Channel("HBO"));
        tvSet.tvChannel[2].addBroadcast(new Broadcast("The Game of Thrones", LocalTime.parse("00:00:00"), LocalTime.parse("09:00:00")));
        tvSet.tvChannel[2].addBroadcast(new Broadcast("Sherlock Holmes", LocalTime.parse("09:00:01"), LocalTime.parse("14:00:00")));
        tvSet.tvChannel[2].addBroadcast(new Broadcast("Doctor Chaos", LocalTime.parse("14:00:01"), LocalTime.parse("21:00:00")));
        tvSet.tvChannel[2].addBroadcast(new Broadcast("Robot", LocalTime.parse("21:00:01"), LocalTime.parse("23:59:59")));
        tvSet.addChannel(new Channel("Disney"));
        tvSet.tvChannel[3].addBroadcast(new Broadcast("Fines and Ferb", LocalTime.parse("00:00:00"), LocalTime.parse("04:30:00")));
        tvSet.tvChannel[3].addBroadcast(new Broadcast("Rick and Morti", LocalTime.parse("04:30:01"), LocalTime.parse("08:00:00")));
        tvSet.tvChannel[3].addBroadcast(new Broadcast("Gravity Falls", LocalTime.parse("08:00:01"), LocalTime.parse("14:50:00")));
        tvSet.tvChannel[3].addBroadcast(new Broadcast("Adventure Time", LocalTime.parse("14:50:01"), LocalTime.parse("23:59:59")));
        tvSet.addChannel(new Channel("Первый канал"));
        tvSet.tvChannel[4].addBroadcast(new Broadcast("Morning News", LocalTime.parse("00:00:00"), LocalTime.parse("08:00:00")));
        tvSet.tvChannel[4].addBroadcast(new Broadcast("Dances on Ice", LocalTime.parse("08:00:01"), LocalTime.parse("17:00:00")));
        tvSet.tvChannel[4].addBroadcast(new Broadcast("Let`s talk", LocalTime.parse("17:00:01"), LocalTime.parse("21:30:00")));
        tvSet.tvChannel[4].addBroadcast(new Broadcast("Evening News", LocalTime.parse("21:30:01"), LocalTime.parse("23:59:59")));
        tvSet.addChannel(new Channel("Россия24"));
        tvSet.tvChannel[5].addBroadcast(new Broadcast("Sport News", LocalTime.parse("00:00:00"), LocalTime.parse("03:00:00")));
        tvSet.tvChannel[5].addBroadcast(new Broadcast("Footbal Match", LocalTime.parse("07:00:01"), LocalTime.parse("10:00:00")));
        tvSet.tvChannel[5].addBroadcast(new Broadcast("Hockey Match", LocalTime.parse("10:00:01"), LocalTime.parse("18:00:00")));
        tvSet.tvChannel[5].addBroadcast(new Broadcast("News", LocalTime.parse("18:00:01"), LocalTime.parse("23:59:59")));
        tvSet.addChannel(new Channel("NationalGeographic"));
        tvSet.tvChannel[6].addBroadcast(new Broadcast("Nature", LocalTime.parse("00:00:00"), LocalTime.parse("08:00:00")));
        tvSet.tvChannel[6].addBroadcast(new Broadcast("Pinguin`s Time", LocalTime.parse("08:00:01"), LocalTime.parse("17:00:00")));
        tvSet.tvChannel[6].addBroadcast(new Broadcast("Lion`s Time", LocalTime.parse("17:00:01"), LocalTime.parse("23:00:00")));
        tvSet.tvChannel[6].addBroadcast(new Broadcast("Nature News", LocalTime.parse("23:00:01"), LocalTime.parse("23:59:59")));
        tvSet.addChannel(new Channel("CTC"));
        tvSet.tvChannel[7].addBroadcast(new Broadcast("Воронины", LocalTime.parse("00:00:00"), LocalTime.parse("03:00:00")));
        tvSet.tvChannel[7].addBroadcast(new Broadcast("Кухня", LocalTime.parse("03:00:01"), LocalTime.parse("07:00:00")));
        tvSet.tvChannel[7].addBroadcast(new Broadcast("Хрень 1", LocalTime.parse("07:00:01"), LocalTime.parse("14:00:00")));
        tvSet.tvChannel[7].addBroadcast(new Broadcast("Хрень 2", LocalTime.parse("14:00:01"), LocalTime.parse("23:59:59")));
        tvSet.addChannel(new Channel("ТНТ"));
        tvSet.tvChannel[8].addBroadcast(new Broadcast("Интерны", LocalTime.parse("00:00:00"), LocalTime.parse("04:00:00")));
        tvSet.tvChannel[8].addBroadcast(new Broadcast("Наша Russia", LocalTime.parse("04:00:01"), LocalTime.parse("09:00:00")));
        tvSet.tvChannel[8].addBroadcast(new Broadcast("Comedy Club", LocalTime.parse("09:00:01"), LocalTime.parse("18:00:00")));
        tvSet.tvChannel[8].addBroadcast(new Broadcast("House of the ill 2", LocalTime.parse("18:00:01"), LocalTime.parse("23:59:59")));
        tvSet.addChannel(new Channel("НТВ"));
        tvSet.tvChannel[9].addBroadcast(new Broadcast("Some 1", LocalTime.parse("00:00:00"), LocalTime.parse("10:00:00")));
        tvSet.tvChannel[9].addBroadcast(new Broadcast("Some 2", LocalTime.parse("10:00:01"), LocalTime.parse("14:00:00")));
        tvSet.tvChannel[9].addBroadcast(new Broadcast("Some 3", LocalTime.parse("20:00:01"), LocalTime.parse("20:00:00")));
        tvSet.tvChannel[9].addBroadcast(new Broadcast("Some 4", LocalTime.parse("15:00:01"), LocalTime.parse("23:59:59")));
        pult.changeChannel("2x2");
        pult.changeChannel("HBO");
        pult.changeChannel("НТВ");
    }
}
