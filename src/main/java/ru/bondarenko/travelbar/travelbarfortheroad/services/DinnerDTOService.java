package ru.bondarenko.travelbar.travelbarfortheroad.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bondarenko.travelbar.travelbarfortheroad.DTO.CountryDTO;
import ru.bondarenko.travelbar.travelbarfortheroad.DTO.DinnerDTO;
import ru.bondarenko.travelbar.travelbarfortheroad.models.Country;
import ru.bondarenko.travelbar.travelbarfortheroad.models.Dinner;

import java.util.stream.Collectors;

@Service
public class DinnerDTOService {
/**
    public CountryDTOService countryDTOService;

    @Autowired
    public DinnerDTOService(CountryDTOService countryDTOService) {
        this.countryDTOService = countryDTOService;
    }

   */

    public DinnerDTO convertToDinnerDTO (Dinner dinner) {
        DinnerDTO dinnerDTO = new DinnerDTO();
        dinnerDTO.setDinnerName(dinner.getDinnerName());
        dinnerDTO.setDinnerConsist(dinner.getDinnerConsist());
        return dinnerDTO;
    }

    public Dinner convertToDinner (DinnerDTO dinnerDTO) {
        Dinner dinner = new Dinner();
        dinner.setDinnerName(dinnerDTO.getDinnerName());
        dinner.setDinnerConsist(dinnerDTO.getDinnerConsist());
        return dinner;
    }


}
