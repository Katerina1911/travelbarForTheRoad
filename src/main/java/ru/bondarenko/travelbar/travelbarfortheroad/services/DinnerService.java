package ru.bondarenko.travelbar.travelbarfortheroad.services;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import ru.bondarenko.travelbar.travelbarfortheroad.models.City;
import ru.bondarenko.travelbar.travelbarfortheroad.models.Dinner;
import ru.bondarenko.travelbar.travelbarfortheroad.repositories.DinnerRepository;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
@Transactional(readOnly = true)
public class DinnerService {

    private final DinnerRepository dinnerRepository;

    @Autowired
    public DinnerService(DinnerRepository dinnerRepository) {
        this.dinnerRepository = dinnerRepository;
    }

    public List<Dinner> allDinners() {
        return dinnerRepository.findAll();
    }

}
