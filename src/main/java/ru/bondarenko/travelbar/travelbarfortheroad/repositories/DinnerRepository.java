package ru.bondarenko.travelbar.travelbarfortheroad.repositories;

import org.springframework.stereotype.Repository;
import ru.bondarenko.travelbar.travelbarfortheroad.models.City;
import ru.bondarenko.travelbar.travelbarfortheroad.models.Dinner;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface DinnerRepository extends JpaRepository<Dinner, Integer> {


}
