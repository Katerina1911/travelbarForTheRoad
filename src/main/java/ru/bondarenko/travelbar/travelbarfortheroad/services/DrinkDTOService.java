package ru.bondarenko.travelbar.travelbarfortheroad.services;

import org.springframework.stereotype.Service;
import ru.bondarenko.travelbar.travelbarfortheroad.DTO.DrinkDTO;
import ru.bondarenko.travelbar.travelbarfortheroad.models.Drink;

@Service
public class DrinkDTOService {

    public DrinkDTO convertToDrinkDTO (Drink drink) {
        DrinkDTO drinkDTO = new DrinkDTO();
        drinkDTO.setDrinkName(drink.getDrinkName());
        drinkDTO.setDrinkConsist(drink.getDrinkConsist());
        return drinkDTO;
    }

    public Drink convertToDrink (DrinkDTO drinkDTO) {
        Drink drink = new Drink();
        drink.setDrinkName(drinkDTO.getDrinkName());
        drink.setDrinkConsist(drinkDTO.getDrinkConsist());
        return drink;
    }


}
