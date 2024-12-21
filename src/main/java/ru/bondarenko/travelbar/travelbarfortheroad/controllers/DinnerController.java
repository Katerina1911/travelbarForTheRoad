package ru.bondarenko.travelbar.travelbarfortheroad.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.bondarenko.travelbar.travelbarfortheroad.DTO.CityDTO;
import ru.bondarenko.travelbar.travelbarfortheroad.DTO.CountryDTO;
import ru.bondarenko.travelbar.travelbarfortheroad.DTO.DinnerDTO;
import ru.bondarenko.travelbar.travelbarfortheroad.models.Country;
import ru.bondarenko.travelbar.travelbarfortheroad.models.Dinner;
import ru.bondarenko.travelbar.travelbarfortheroad.services.DinnerDTOService;
import ru.bondarenko.travelbar.travelbarfortheroad.services.DinnerService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class DinnerController {

    private final DinnerService dinnerService;
    private final DinnerDTOService dinnerDTOService;

    @Autowired
    public DinnerController(DinnerService dinnerService, DinnerDTOService dinnerDTOService) {
        this.dinnerService = dinnerService;
        this.dinnerDTOService = dinnerDTOService;
    }

    @GetMapping("/showAllDinners")
    @ResponseBody
    public List<DinnerDTO> showAllDinners() {
        return dinnerService.allDinners().stream().map(dinnerDTOService::convertToDinnerDTO)
                .collect(Collectors.toList());
    }




}
