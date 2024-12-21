package ru.bondarenko.travelbar.travelbarfortheroad.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bondarenko.travelbar.travelbarfortheroad.models.Dinner;
import ru.bondarenko.travelbar.travelbarfortheroad.models.Drink;
import ru.bondarenko.travelbar.travelbarfortheroad.repositories.DinnerRepository;
import ru.bondarenko.travelbar.travelbarfortheroad.repositories.DrinkRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class DrinkService {

    private final DrinkRepository drinkRepository;

    @Autowired
    public DrinkService(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

    public List<Drink> allDrinks() {
        return drinkRepository.findAll();
    }
}
