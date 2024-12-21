package ru.bondarenko.travelbar.travelbarfortheroad.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bondarenko.travelbar.travelbarfortheroad.models.Drink;
import ru.bondarenko.travelbar.travelbarfortheroad.models.Snack;
import ru.bondarenko.travelbar.travelbarfortheroad.repositories.SnackRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class SnackService {

    private final SnackRepository snackRepository;

    @Autowired
    public SnackService(SnackRepository snackRepository) {
        this.snackRepository = snackRepository;
    }

    public List<Snack> allSnacks() {
        return snackRepository.findAll();
    }

}
