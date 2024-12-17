package ru.bondarenko.travelbar.travelbarfortheroad.services;

import io.micrometer.observation.ObservationFilter;
import org.apache.catalina.mapper.Mapper;
import org.hibernate.MappingException;
import org.hibernate.mapping.Collection;
import org.hibernate.mapping.Value;
import org.hibernate.mapping.ValueVisitor;
import org.hibernate.type.CollectionType;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bondarenko.travelbar.travelbarfortheroad.DTO.CityDTO;
import ru.bondarenko.travelbar.travelbarfortheroad.DTO.CountryDTO;
import ru.bondarenko.travelbar.travelbarfortheroad.models.City;
import ru.bondarenko.travelbar.travelbarfortheroad.models.Country;
import ru.bondarenko.travelbar.travelbarfortheroad.repositories.CityRepository;
import ru.bondarenko.travelbar.travelbarfortheroad.repositories.CountryRepository;

import java.util.*;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository, CityRepository cityRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> allCountries () {
        return countryRepository.findAllCountries();
    }

    public Map<Country, List<City>> allCountriesAndCities() {
        Map<Country, List<City>> info = new HashMap<>();
        for (Country country : countryRepository.findAll()) {
            info.put(country, country.getCities());
        }
        return info;
    }




    /**public static Map<Country, List<City>> allCountriesAndCities() {
        Map<Country, List<City>> info = new HashMap<>();
        for (Country country : countryRepository.findAll()) {
            info.put(country, country.getCities());
        }
        return info;
    }*/

   /**public static Map<CountryDTO, List<CityDTO>> allCountriesAndCities() {
        Map<CountryDTO, List<CityDTO>> info = new HashMap<>();
        for (CountryDTO country : countryRepository.findAllCountries()) {
            info.put(country, country.getCities());
        }
        return info;
    }*/

    /**public static Map<CountryDTO, CityDTO> allCountriesAndCities() {
        Map<CountryDTO, CityDTO> info = new HashMap<>();
        for (CountryDTO country : countryRepository.findAllCountries()) {
            for (CityDTO city : country.getCities()) {
                info.put(country, city);
            }
        }
        return info;
    }*/

}
