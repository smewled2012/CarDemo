package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner{

    @Autowired
    CarRepository carRepository;

    public void run (String... strings) throws Exception{

        Car car1=new Car("2015","Nissan","Sentra");
        carRepository.save(car1);
        car1=new Car("2009","Toyota","Yaris");
        carRepository.save(car1);

    }
}
