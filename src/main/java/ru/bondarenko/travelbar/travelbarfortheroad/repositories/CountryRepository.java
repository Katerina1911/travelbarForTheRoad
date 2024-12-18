package ru.bondarenko.travelbar.travelbarfortheroad.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.bondarenko.travelbar.travelbarfortheroad.models.Country;
import ru.bondarenko.travelbar.travelbarfortheroad.DTO.CountryDTO;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface CountryRepository extends JpaRepository<Country, Integer> {
    Optional<Country> findByCountry(String country);

@Query("SELECT new ru.bondarenko.travelbar.travelbarfortheroad.models.Country (u.country) FROM Country u")
List<Country> findAllCountries();
}
