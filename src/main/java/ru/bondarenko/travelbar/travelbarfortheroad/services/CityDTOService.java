package ru.bondarenko.travelbar.travelbarfortheroad.services;

import org.springframework.stereotype.Service;
import ru.bondarenko.travelbar.travelbarfortheroad.DTO.CityDTO;
import ru.bondarenko.travelbar.travelbarfortheroad.models.City;

@Service
public class CityDTOService {

    public CityDTO convertToCityDTO (City city) {
        CityDTO cityDTO = new CityDTO();
        cityDTO.setCity(city.getCity());
        return cityDTO;
    }

    public City convertToCity (CityDTO cityDTO) {
        City city = new City();
        city.setCity(cityDTO.getCity());
        return city;
    }



}
