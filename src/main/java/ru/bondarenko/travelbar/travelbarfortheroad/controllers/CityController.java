package ru.bondarenko.travelbar.travelbarfortheroad.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.bondarenko.travelbar.travelbarfortheroad.DTO.CityDTO;
import ru.bondarenko.travelbar.travelbarfortheroad.DTO.CountryDTO;
import ru.bondarenko.travelbar.travelbarfortheroad.models.City;
import ru.bondarenko.travelbar.travelbarfortheroad.models.Country;
import ru.bondarenko.travelbar.travelbarfortheroad.services.CityDTOService;
import ru.bondarenko.travelbar.travelbarfortheroad.services.CityService;
import ru.bondarenko.travelbar.travelbarfortheroad.services.CountryService;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class CityController {

    private final CityService cityService;
    private final CityDTOService cityDTOService;

    @Autowired
    public CityController(CityService cityService, CityDTOService cityDTOService) {
        this.cityService = cityService;
        this.cityDTOService = cityDTOService;
    }

    @GetMapping("/showAllCities")
    @ResponseBody
    public List<CityDTO> showAllCities() {
        return cityService.allCities().stream().map(cityDTOService::convertToCityDTO)
                .collect(Collectors.toList());
    }





   /** public CityDTO convertToCityDTO (City city) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(city, CityDTO.class);
    }

    public City convertToCity(CityDTO cityDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(cityDTO, City.class);
    }*/

}


