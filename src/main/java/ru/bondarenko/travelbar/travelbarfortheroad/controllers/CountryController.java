package ru.bondarenko.travelbar.travelbarfortheroad.controllers;

import io.micrometer.observation.ObservationFilter;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.bondarenko.travelbar.travelbarfortheroad.DTO.CityDTO;
import ru.bondarenko.travelbar.travelbarfortheroad.DTO.CountryDTO;
import ru.bondarenko.travelbar.travelbarfortheroad.models.City;
import ru.bondarenko.travelbar.travelbarfortheroad.models.Country;
import ru.bondarenko.travelbar.travelbarfortheroad.repositories.CityRepository;
import ru.bondarenko.travelbar.travelbarfortheroad.services.CountryService;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Controller
public class CountryController {

private CountryService countryService;

    //private ModelMapper modelMapper;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/showAllCountries")
    @ResponseBody
    public List<CountryDTO> showAllCountries () {
        return countryService.allCountries();
    }

    @GetMapping("/showAllCountriesAndCities")
    @ResponseBody
    public Map<CountryDTO, List<CityDTO>> showAllCountriesAndCities () {
        return CountryService.allCountriesAndCities();
    }


   /** public CountryDTO convertToCountryDTO (Country country) {
        return this.modelMapper.map(country, CountryDTO.class);
    }

    public Country convertToCountry(CountryDTO countryDTO) {
        return this.modelMapper.map(countryDTO, Country.class);
    }*/

}
