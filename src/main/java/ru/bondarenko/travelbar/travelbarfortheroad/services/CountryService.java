package ru.bondarenko.travelbar.travelbarfortheroad.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import ru.bondarenko.travelbar.travelbarfortheroad.models.Country;
import ru.bondarenko.travelbar.travelbarfortheroad.repositories.CityRepository;
import ru.bondarenko.travelbar.travelbarfortheroad.repositories.CountryRepository;

import java.util.*;

@Service
public class CountryService {

    /**@PersistenceContext
    private EntityManager entityManager;*/

    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository, CityRepository cityRepository) {
        this.countryRepository = countryRepository;
    }

   /**public List<Country> getAll() {
        return entityManager.createQuery("from Country c order by c.id desc", Country.class).getResultList();
    }

    public Country getById(int id) {
        return entityManager.find(Country.class, id);
    }

    public Country create(Country country) {
        for (City city : country.getCities()) {
            city.setCountry(country);
        }
        entityManager.persist(country);
        return country;
    }*/

    public List<Country> allCountriesAndCities () {
        return countryRepository.findAll();
    }

    public List<Country> allCountries() {
        return countryRepository.findAllCountries();
    }









    /**public static Map<Country, List<City>> allCountriesAndCities() {
        Map<Country, List<City>> info = new HashMap<>();
        for (Country country : countryRepository.findAll()) {
            info.put(country, country.getCities());
        }
        return info;
    }*/



}
