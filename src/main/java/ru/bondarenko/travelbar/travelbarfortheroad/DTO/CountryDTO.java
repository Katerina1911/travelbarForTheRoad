package ru.bondarenko.travelbar.travelbarfortheroad.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import ru.bondarenko.travelbar.travelbarfortheroad.models.City;

import java.util.List;

import static jakarta.persistence.FetchType.EAGER;
import static jakarta.persistence.FetchType.LAZY;

public class CountryDTO {

    @NotEmpty(message = "Название страны не должно быть пустым")
    @Size(min = 2, max = 100, message = " должно быть от 2 до 100 символов длиной")
    private String country;

    public CountryDTO() {
    }


    public CountryDTO(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry (String country) {
        this.country = country;
    }

//   @OneToMany(mappedBy = "country", fetch = LAZY)     // ДОБАВЛЯЮТСЯ ГОРОДА NULL ПРИ ПОИСКЕ ВСЕХ СТРАН
/*  private List<City> cities;

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }*/

    @Override
    public String toString() {
        return "CountryDTO{" +
                "country='" + country + '\'' +
               // ", cities=" + cities +
                '}';
    }
}
