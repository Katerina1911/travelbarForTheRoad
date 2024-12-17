package ru.bondarenko.travelbar.travelbarfortheroad.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import ru.bondarenko.travelbar.travelbarfortheroad.models.Country;



public class CityDTO {

    @NotEmpty(message = "Название города не должно быть пустым")
    @Size(min = 2, max = 100, message = "Название города должно быть от 2 до 100 символов длиной")
    private String city;

    public CityDTO() {
    }

    public CityDTO(String city) {
        this.city = city;
    }

    public  String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

   /** private Country country;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }*/

    @Override
    public String toString() {
        return "CityDTO{" +
                "city='" + city + '\'' +
             //   ", country=" + country +
                '}';
    }
}
