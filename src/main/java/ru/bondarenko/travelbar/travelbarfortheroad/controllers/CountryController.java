package ru.bondarenko.travelbar.travelbarfortheroad.controllers;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import ru.bondarenko.travelbar.travelbarfortheroad.DTO.*;
import ru.bondarenko.travelbar.travelbarfortheroad.models.*;
import ru.bondarenko.travelbar.travelbarfortheroad.services.CountryDTOService;
import ru.bondarenko.travelbar.travelbarfortheroad.services.CountryService;


import ru.bondarenko.travelbar.travelbarfortheroad.util.AppErrorResponse;
import ru.bondarenko.travelbar.travelbarfortheroad.util.CountryNotCreatedException;
import ru.bondarenko.travelbar.travelbarfortheroad.util.CountryNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class CountryController {

    private final CountryService countryService;
    private final CountryDTOService countryDTOService;

    @Autowired
    public CountryController(CountryService countryService, CountryDTOService countryDTOService) {
        this.countryService = countryService;
        this.countryDTOService = countryDTOService;
    }

    @GetMapping("/countries")
    public List<String> getAllCountries() {
        return countryService.allCountries();
    }

    @GetMapping("/country/{id}")
    public CountryDTO getCountry(@PathVariable("id")int id) {
        return countryDTOService.countryDTOAll(countryService.findOneCountry(id));
    }

////////////////////////

    @PostMapping("/createCountryMenu")
    public ResponseEntity<HttpStatus> create(@RequestBody @Valid CountryDTO countryDTO, // или вернуть объект страна
                                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder errorMsg =new StringBuilder();

            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                errorMsg.append(error.getField())
                        .append(" - ").append(error.getDefaultMessage())
                        .append(";");
            }
            throw new CountryNotCreatedException(errors.toString());
        }
        countryService.saveCountryMenu(countryDTOService.convertCountryDTOAll(countryDTO));   // заменить дто
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PatchMapping("/updateCountryMenu")
    public ResponseEntity<HttpStatus> updateCountry(@ModelAttribute("country") @Valid CountryDTO countryDTO,
                                                    BindingResult bindingResult,
                                                    @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            StringBuilder errorMsg =new StringBuilder();

            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                errorMsg.append(error.getField())
                        .append(" - ").append(error.getDefaultMessage())
                        .append(";");
            }
            throw new CountryNotCreatedException(errors.toString());
        }
        countryService.updateCountryMenu(id, countryDTOService.convertCountryDTOAll(countryDTO));
        // заменить дто
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/deleteCountryMenu")
    public void deleteCountry(@PathVariable("id") int id) {
        countryService.deleteCountryMenu(id);
    }
////////////////////









    /**@GetMapping("/showAllCountriesAndCities")
      public List<CountryDTO> showAllCountriesAndCities () {
          return countryService.allCountriesAndCities().stream().map(countryDTOService::convertToCountryDTO)
                  .collect(Collectors.toList());
      }*/

   // @GetMapping("/showAllCountriesAndCities")
   // public List<List<Country>> showAllCountriesAndCities () {
   //     return countryService.allCountriesAndCities();
    // }

    @GetMapping("/showAllMenu")     // показывает города
    public List<CountryDTO> showAllMenu () {
        return countryService.allMenu().stream().map(countryDTOService::countryDTOAll)
                .collect(Collectors.toList());
    }

    @GetMapping("/showAllCountriesAndDinners")
    public Map<String, DinnerDTO> showAllCountriesAndDinners () {
        return countryDTOService.convertToCountryAndDinnerDTO(countryService.allCountriesAndDinners());
    }

    @GetMapping("/showAllCountriesMenu")
    public List<CountryDTO> showAllCountriesMenu() {
        return countryService.allCountriesSnackDrinks().stream().map(countryDTOService::countryDTOAllCountriesMenu)
                .collect(Collectors.toList());
    }















      @ExceptionHandler
      private ResponseEntity<AppErrorResponse> handleException(CountryNotFoundException e) {
          AppErrorResponse response = new AppErrorResponse(
                  "Страны с таким id не найдено",
                  System.currentTimeMillis()
          );
          return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
      }

    @ExceptionHandler
    private ResponseEntity<AppErrorResponse> handleException(CountryNotCreatedException e) {
        AppErrorResponse response = new AppErrorResponse(
                e.getMessage(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }







  /** public CountryDTO convertToCountryDTO (Country country) {
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
        }*/

}
