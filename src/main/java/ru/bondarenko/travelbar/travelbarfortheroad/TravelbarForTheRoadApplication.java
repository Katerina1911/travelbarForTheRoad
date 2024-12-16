package ru.bondarenko.travelbar.travelbarfortheroad;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.bondarenko.travelbar.travelbarfortheroad.controllers.CountryController;
import ru.bondarenko.travelbar.travelbarfortheroad.models.Country;

@SpringBootApplication
public class TravelbarForTheRoadApplication {

    public static void main(String[] args) {
        SpringApplication.run(TravelbarForTheRoadApplication.class, args);
    }

    /**@Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }*/



}
