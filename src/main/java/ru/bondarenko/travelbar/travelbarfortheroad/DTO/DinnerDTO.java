package ru.bondarenko.travelbar.travelbarfortheroad.DTO;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import ru.bondarenko.travelbar.travelbarfortheroad.models.Country;

import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DinnerDTO {

    @NotEmpty(message = "Меню обеда не должно быть пустым")
    @Size(min = 2, max = 300, message = "Меню обеда должно быть от 2 до 100 символов длиной")
    private String dinnerName;

    @NotEmpty(message = "Состав обеда не должен быть пустым")
    private String dinnerConsist;

   public DinnerDTO() {
    }

    public DinnerDTO(String dinnerName, String dinnerConsist) {
        this.dinnerName = dinnerName;
        this.dinnerConsist = dinnerConsist;
    }

    public @NotEmpty(message = "Меню обеда не должно быть пустым") @Size(min = 2, max = 300, message = "Меню обеда должно быть от 2 до 100 символов длиной") String getDinnerName() {
        return dinnerName;
    }

    public void setDinnerName(@NotEmpty(message = "Меню обеда не должно быть пустым") @Size(min = 2, max = 300, message = "Меню обеда должно быть от 2 до 100 символов длиной") String dinnerName) {
        this.dinnerName = dinnerName;
    }

    public @NotEmpty(message = "Состав обеда не должен быть пустым") String getDinnerConsist() {
        return dinnerConsist;
    }

    public void setDinnerConsist(@NotEmpty(message = "Состав обеда не должен быть пустым") String dinnerConsist) {
        this.dinnerConsist = dinnerConsist;
    }

   private CountryDTO country;

    public CountryDTO getCountry() {
        return country;
    }

    public void setCountry(CountryDTO country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "{" +
                "dinnerName='" + dinnerName + '\'' +
                ", dinnerConsist='" + dinnerConsist + '\'' +
                '}';
    }
}
