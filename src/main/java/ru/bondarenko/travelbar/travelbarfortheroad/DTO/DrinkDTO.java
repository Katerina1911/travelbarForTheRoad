package ru.bondarenko.travelbar.travelbarfortheroad.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DrinkDTO {

    @NotEmpty(message = "Название настойки не должно быть пустым")
    @Size(min = 2, max = 100, message = "Название настойки должно быть от 2 до 100 символов длиной")
    private String drinkName;

    @NotEmpty(message = "Состав настойки не должен быть пустым")
    private String drinkConsist;

    public DrinkDTO() {
    }

    public DrinkDTO(String drinkName, String drinkConsist) {
        this.drinkName = drinkName;
        this.drinkConsist = drinkConsist;
    }

    public @NotEmpty(message = "Название настойки не должно быть пустым") @Size(min = 2, max = 100, message = "Название настойки должно быть от 2 до 100 символов длиной") String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(@NotEmpty(message = "Название настойки не должно быть пустым") @Size(min = 2, max = 100, message = "Название настойки должно быть от 2 до 100 символов длиной") String drinkName) {
        this.drinkName = drinkName;
    }

    public @NotEmpty(message = "Состав настойки не должен быть пустым") String getDrinkConsist() {
        return drinkConsist;
    }

    public void setDrinkConsist(@NotEmpty(message = "Состав настойки не должен быть пустым") String drinkConsist) {
        this.drinkConsist = drinkConsist;
    }

    @Override
    public String toString() {
        return "{" +
                "drinkName='" + drinkName + '\'' +
                ", drinkConsist='" + drinkConsist + '\'' +
                '}';
    }
}
