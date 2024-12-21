package ru.bondarenko.travelbar.travelbarfortheroad.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.bondarenko.travelbar.travelbarfortheroad.DTO.DinnerDTO;
import ru.bondarenko.travelbar.travelbarfortheroad.DTO.SnackDTO;
import ru.bondarenko.travelbar.travelbarfortheroad.services.DrinkDTOService;
import ru.bondarenko.travelbar.travelbarfortheroad.services.DrinkService;
import ru.bondarenko.travelbar.travelbarfortheroad.services.SnackDTOService;
import ru.bondarenko.travelbar.travelbarfortheroad.services.SnackService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SnackController {

    private final SnackService snackService;
    private final SnackDTOService snackDTOService;

    @Autowired
    public SnackController(SnackService snackService, SnackDTOService snackDTOService) {
        this.snackService = snackService;
        this.snackDTOService = snackDTOService;
    }

    @GetMapping("/showAllSnacks")
    @ResponseBody
    public List<SnackDTO> showAllSnacks() {
        return snackService.allSnacks().stream().map(snackDTOService::convertToSnackDTO)
                .collect(Collectors.toList());
    }

}
