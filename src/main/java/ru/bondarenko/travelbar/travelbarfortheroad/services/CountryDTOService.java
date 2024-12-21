package ru.bondarenko.travelbar.travelbarfortheroad.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bondarenko.travelbar.travelbarfortheroad.DTO.CountryDTO;
import ru.bondarenko.travelbar.travelbarfortheroad.DTO.DinnerDTO;
import ru.bondarenko.travelbar.travelbarfortheroad.models.Country;
import ru.bondarenko.travelbar.travelbarfortheroad.models.Dinner;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;


@Service
public class CountryDTOService {

    public CityDTOService cityDTOService;
    public DinnerDTOService dinnerDTOService;
    public DrinkDTOService drinkDTOService;
    public SnackDTOService snackDTOService;

    @Autowired
    public CountryDTOService(CityDTOService cityDTOService, DinnerDTOService dinnerDTOService, DrinkDTOService drinkDTOService, SnackDTOService snackDTOService) {
        this.cityDTOService = cityDTOService;
        this.dinnerDTOService = dinnerDTOService;
        this.drinkDTOService = drinkDTOService;
        this.snackDTOService = snackDTOService;
    }

    public CountryDTO countryDTOAll (Country country) {
        CountryDTO countryDTO = new CountryDTO();
        countryDTO.setCountry(country.getCountry());
        countryDTO.setCities(country.getCities().stream().map(city -> cityDTOService.convertToCityDTO(city))
                .collect(Collectors.toList()));
        countryDTO.setDinner(dinnerDTOService.convertToDinnerDTO(country.getDinner()));
        countryDTO.setSnacks(country.getSnacks().stream().map(snack -> snackDTOService.convertToSnackDTO(snack))
                .collect(Collectors.toList()));
        countryDTO.setDrinks(country.getDrinks().stream().map(drink -> drinkDTOService.convertToDrinkDTO(drink))
                .collect(Collectors.toList()));
        return countryDTO;
    }

    public Country convertCountryDTOAll (CountryDTO countryDTO) {
        Country country = new Country();
        country.setCountry(countryDTO.getCountry());
        country.setCities(countryDTO.getCities().stream().map(city -> cityDTOService.convertToCity(city))
                .collect(Collectors.toList()));
        country.setDinner(dinnerDTOService.convertToDinner(countryDTO.getDinner()));
        country.setSnacks(countryDTO.getSnacks().stream().map(snack -> snackDTOService.convertToSnack(snack))
                .collect(Collectors.toList()));
        country.setDrinks(countryDTO.getDrinks().stream().map(drink -> drinkDTOService.convertToDrink(drink))
                .collect(Collectors.toList()));
        return country;
    }

    public CountryDTO convertToCountryDTO (Country country) {
        CountryDTO countryDTO = new CountryDTO();
        countryDTO.setCountry(country.getCountry());
        return countryDTO;
    }

    public Country convertToCountry (CountryDTO countryDTO) {
        Country country = new Country();
        country.setCountry(countryDTO.getCountry());
        return country;
    }

    public Map<String, DinnerDTO> convertToCountryAndDinnerDTO (Map<String, Dinner> map) {
        Map<String, DinnerDTO> mapDTO = new TreeMap<>();
        for (String key : map.keySet()) {
            Dinner value = map.get(key);
            mapDTO.put(key, dinnerDTOService.convertToDinnerDTO(value));
        }
        return mapDTO;
    }

    public CountryDTO countryDTOAllCountriesMenu (Country country) {
        CountryDTO countryDTO = new CountryDTO();
        countryDTO.setCountry(country.getCountry());
        countryDTO.setCities(country.getCities().stream().map(city -> cityDTOService.convertToCityDTO(city))
                .collect(Collectors.toList()));
        countryDTO.setSnacks(country.getSnacks().stream().map(snack -> snackDTOService.convertToSnackDTO(snack))
                .collect(Collectors.toList()));
        countryDTO.setDrinks(country.getDrinks().stream().map(drink -> drinkDTOService.convertToDrinkDTO(drink))
                .collect(Collectors.toList()));
        return countryDTO;
    }
}
