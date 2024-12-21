package ru.bondarenko.travelbar.travelbarfortheroad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bondarenko.travelbar.travelbarfortheroad.models.City;
import ru.bondarenko.travelbar.travelbarfortheroad.models.Drink;

@Repository
public interface DrinkRepository extends JpaRepository<Drink, Integer> {

}
