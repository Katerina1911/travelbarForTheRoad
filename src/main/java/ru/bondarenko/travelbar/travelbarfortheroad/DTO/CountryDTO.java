package ru.bondarenko.travelbar.travelbarfortheroad.DTO;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
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

  private List<CityDTO> cities;

    @JsonCreator
    public CountryDTO(@JsonProperty("cities") List<CityDTO> cities) {
        this.cities = cities;
    }

    public List<CityDTO> getCities() {
        return cities;
    }

    public void setCities(List<CityDTO> cities) {
        this.cities = cities;
    }

    @Override
    public String toString() {
        return "CountryDTO{" +
                "country='" + country + '\'' +
                '}';
    }
}
