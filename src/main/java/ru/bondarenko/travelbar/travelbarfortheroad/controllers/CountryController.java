package ru.bondarenko.travelbar.travelbarfortheroad.controllers;

import io.micrometer.observation.ObservationFilter;
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
import java.util.stream.Collectors;

@Controller
public class CountryController {

private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/showAllCountries")
    @ResponseBody
    public List<CountryDTO> showAllCountries () {
        return countryService.allCountries().stream().map(this::convertToCountryDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/showAllCountriesAndCities")     // не работает
    @ResponseBody
    public Map<Country, List<City>> showAllCountriesAndCities () {
        return countryService.allCountriesAndCities();
    }

   /** @GetMapping("/showAllCountriesAndCities")     // не работает
    @ResponseBody
    public Map<Country, List<City>> showAllCountriesAndCities () {
        return CountryService.allCountriesAndCities();
    }*/


   public CountryDTO convertToCountryDTO (Country country) {
        ModelMapper modelMapper = new ModelMapper();
       return modelMapper.map(country, CountryDTO.class);
    }

    public Country convertToCountry(CountryDTO countryDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(countryDTO, Country.class);
    }

        public CityDTO convertToCityDTO (City city) {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(city, CityDTO.class);
        }

        public City convertToCity(CityDTO cityDTO) {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(cityDTO, City.class);
        }

}
