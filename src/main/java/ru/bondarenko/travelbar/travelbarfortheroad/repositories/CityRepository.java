package ru.bondarenko.travelbar.travelbarfortheroad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.bondarenko.travelbar.travelbarfortheroad.DTO.CityDTO;
import ru.bondarenko.travelbar.travelbarfortheroad.models.City;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
    Optional<City> findByCity(String city);

    @Query("SELECT new ru.bondarenko.travelbar.travelbarfortheroad.DTO.CityDTO (u.city) FROM City u")
    List<CityDTO> findAllCities();
}
