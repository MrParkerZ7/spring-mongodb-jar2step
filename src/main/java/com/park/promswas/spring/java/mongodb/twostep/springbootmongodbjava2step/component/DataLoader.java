package com.park.promswas.spring.java.mongodb.twostep.springbootmongodbjava2step.component;

import com.park.promswas.spring.java.mongodb.twostep.springbootmongodbjava2step.document.Address;
import com.park.promswas.spring.java.mongodb.twostep.springbootmongodbjava2step.document.Hotel;
import com.park.promswas.spring.java.mongodb.twostep.springbootmongodbjava2step.document.Review;
import com.park.promswas.spring.java.mongodb.twostep.springbootmongodbjava2step.repository.HotelRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private HotelRepository hotelRepository;

    public DataLoader(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public void run(String... strings) throws Exception {

        this.hotelRepository.deleteAll();

        List<Hotel> hotels = Arrays.asList(
                new Hotel("Mareena", 3500,
                        new Address("Bangkok", "Thailand"),
                        Arrays.asList(
                                new Review("Park", 8, true),
                                new Review("Suck", 3, false),
                                new Review("Fuck", 9, true),
                                new Review("Park", 7, true),
                                new Review("Rojo", 7, true))),
                new Hotel("Boss", 2700,
                        new Address("Ubon", "Thailand"),
                        Arrays.asList(
                                new Review("Park", 8, true),
                                new Review("Serker", 2, false),
                                new Review("Jo", 10, true),
                                new Review("Mice", 9, true))),
                new Hotel("Sea", 4500,
                        new Address("Non", "Thailand"),
                        new ArrayList<>()),
                new Hotel("Cross", 1700,
                        new Address("Sisaket", "Thailand"),
                        Arrays.asList(
                                new Review("Ken", 8, true),
                                new Review("John", 9, true),
                                new Review("Macro", 5, false))),
                new Hotel("Home", 7500,
                        new Address("Bangkok", "Thailand"),
                        Arrays.asList(
                                new Review("Mayu", 10, true))),
                new Hotel("Porn Hub", 9900,
                        new Address("Bangkok", "Thailand"),
                        Arrays.asList(
                                new Review("Samuji", 7, false)))
        );
        this.hotelRepository.save(hotels);
    }
}
