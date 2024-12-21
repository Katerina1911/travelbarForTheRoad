package ru.bondarenko.travelbar.travelbarfortheroad.services;

import org.springframework.stereotype.Service;
import ru.bondarenko.travelbar.travelbarfortheroad.DTO.SnackDTO;
import ru.bondarenko.travelbar.travelbarfortheroad.models.Snack;

@Service
public class SnackDTOService {

    public SnackDTO convertToSnackDTO (Snack snack) {
        SnackDTO snackDTO = new SnackDTO();
        snackDTO.setSnackName(snack.getSnackName());
        snackDTO.setSnackConsist(snack.getSnackConsist());
        return snackDTO;
    }

    public Snack convertToSnack (SnackDTO snackDTO) {
        Snack snack = new Snack();
        snack.setSnackName(snackDTO.getSnackName());
        snack.setSnackConsist(snackDTO.getSnackConsist());
        return snack;
    }


}
