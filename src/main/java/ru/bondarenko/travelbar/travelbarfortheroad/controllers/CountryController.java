package ru.bondarenko.travelbar.travelbarfortheroad.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.bondarenko.travelbar.travelbarfortheroad.DTO.CityDTO;
import ru.bondarenko.travelbar.travelbarfortheroad.DTO.CountryDTO;
import ru.bondarenko.travelbar.travelbarfortheroad.models.City;
import ru.bondarenko.travelbar.travelbarfortheroad.models.Country;
import ru.bondarenko.travelbar.travelbarfortheroad.services.CountryService;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CountryController {

private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

   /** @GetMapping("/countries")
    @ResponseBody
    public List<Country> getAllCountries() {
        return countryService.getAll();
    }

    @GetMapping("/countries/{countryId}")
    @ResponseBody
    public Country getCountryById(@PathVariable("countryId") int id) {
        return countryService.getById(id);
    }

    @PostMapping("/countries")
    @ResponseStatus(HttpStatus.CREATED)
    public Country createCountry(@RequestBody Country country) {
        return countryService.create(country);
    }*/


    @GetMapping("/showAllCountriesAndCities")
      @ResponseBody
      public List<CountryDTO> showAllCountriesAndCities () {
          return countryService.allCountriesAndCities().stream().map(this::convertToCountryDTO)
                  .collect(Collectors.toList());
      }

      @GetMapping("/showAllCountries")     // показывает города
      @ResponseBody
      public List<CountryDTO> showAllCountries () {
          return countryService.allCountries().stream().map(this::convertToCountryDTO)
                  .collect(Collectors.toList());
      }





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
