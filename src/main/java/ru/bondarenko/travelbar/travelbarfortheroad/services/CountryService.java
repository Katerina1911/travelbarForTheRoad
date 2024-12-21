package ru.bondarenko.travelbar.travelbarfortheroad.services;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bondarenko.travelbar.travelbarfortheroad.DTO.CountryDTO;
import ru.bondarenko.travelbar.travelbarfortheroad.models.City;
import ru.bondarenko.travelbar.travelbarfortheroad.models.Country;
import ru.bondarenko.travelbar.travelbarfortheroad.models.Dinner;
import ru.bondarenko.travelbar.travelbarfortheroad.repositories.CityRepository;
import ru.bondarenko.travelbar.travelbarfortheroad.repositories.CountryRepository;
import ru.bondarenko.travelbar.travelbarfortheroad.repositories.DinnerRepository;
import ru.bondarenko.travelbar.travelbarfortheroad.util.CountryNotFoundException;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class CountryService {

    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

   //работа с сущностью Country

    public List<String> allCountries() {
        List<String> countries = new ArrayList<>();
        for (Country country : countryRepository.findAll()) {
            countries.add(country.getCountry());
        }
        return countries;
    }

    public List<Country> allMenu () {
        return countryRepository.findAll();
    }

    ///////////////////////////

    //работа с сущностями Country, Dinner

    @JsonAnyGetter
    public Map<String, Dinner> allCountriesAndDinners() {
        Map<String, Dinner> params = new TreeMap<>();
        for (Country country : countryRepository.findAll()) {
            params.put(country.getCountry(), country.getDinner());
        }
        return params;
    }

    //работа с сущностями Country, Snack и Drink

    public List<Country> allCountriesSnackDrinks () {
        List<Country> menu = new ArrayList<>();
        for (Country country : countryRepository.findAll()) {
            Country menuCountry = new Country();
            menuCountry.setCountry(country.getCountry());
            menuCountry.setCities(country.getCities());
            menuCountry.setDrinks(country.getDrinks());
            menuCountry.setSnacks(country.getSnacks());
            menu.add(menuCountry);
        }
        return menu;
    }

    //работа сo всеми сущностями, CRUD

    public Country findOneCountry (int id) {
        Optional<Country> foundCountry = countryRepository.findById(id);
        return foundCountry.orElseThrow(CountryNotFoundException::new);
    }

    @Transactional
    public void saveCountryMenu(Country country) {     // добавить кем выполнялось (роль)
        moreInfoCountry(country);
        countryRepository.save(country);
    }

    @Transactional
    public Country updateCountryMenu (int id, Country updatedCountry) {
        updatedCountry.setId(id);
        moreInfoCountry(updatedCountry);
        return countryRepository.save(updatedCountry);
    }

    // удаляем страну и все связи
    public void deleteCountryMenu (int id) {
        Country foundCountry = countryRepository.findById(id)
                .orElseThrow(CountryNotFoundException::new);
        countryRepository.deleteById(id);
    }

    private void moreInfoCountry (Country country) {
        country.setCreatedAt(LocalDateTime.now());
        country.setUpdatedAt(LocalDateTime.now());
        country.setCreatedWho("ADMIN");
    }



















    /**public static Map<Country, List<City>> allCountriesAndCities() {
        Map<Country, List<City>> info = new HashMap<>();
        for (Country country : countryRepository.findAll()) {
            info.put(country, country.getCities());
        }
        return info;
    }*/



}
