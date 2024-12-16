package ru.bondarenko.travelbar.travelbarfortheroad.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.bondarenko.travelbar.travelbarfortheroad.DTO.CityDTO;
import ru.bondarenko.travelbar.travelbarfortheroad.DTO.CountryDTO;
import ru.bondarenko.travelbar.travelbarfortheroad.models.City;
import ru.bondarenko.travelbar.travelbarfortheroad.models.Country;
import ru.bondarenko.travelbar.travelbarfortheroad.services.CityService;
import ru.bondarenko.travelbar.travelbarfortheroad.services.CountryService;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CityController {

    private final CityService cityService;
    private final CountryService countryService;

    @Autowired
    public CityController(CityService cityService, CountryService countryService) {
        this.cityService = cityService;
        this.countryService = countryService;
    }

    @GetMapping("/showAllCities")
    @ResponseBody
    public List<CityDTO> showAllCities() {
        return CityService.allCities();
    }

}


