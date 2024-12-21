package ru.bondarenko.travelbar.travelbarfortheroad.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.bondarenko.travelbar.travelbarfortheroad.DTO.DinnerDTO;
import ru.bondarenko.travelbar.travelbarfortheroad.DTO.DrinkDTO;
import ru.bondarenko.travelbar.travelbarfortheroad.services.DrinkDTOService;
import ru.bondarenko.travelbar.travelbarfortheroad.services.DrinkService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class DrinkController {

    private final DrinkService drinkService;
    private final DrinkDTOService drinkDTOService;

    @Autowired
    public DrinkController(DrinkService drinkService, DrinkDTOService drinkDTOService) {
        this.drinkService = drinkService;
        this.drinkDTOService = drinkDTOService;
    }

    @GetMapping("/showAllDrinks")
    @ResponseBody
    public List<DrinkDTO> showAllDrinks() {
        return drinkService.allDrinks().stream().map(drinkDTOService::convertToDrinkDTO)
                .collect(Collectors.toList());
    }
}
