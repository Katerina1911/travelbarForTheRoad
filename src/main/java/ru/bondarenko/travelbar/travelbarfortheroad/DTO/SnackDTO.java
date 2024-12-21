package ru.bondarenko.travelbar.travelbarfortheroad.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SnackDTO {

    @NotEmpty(message = "Название снека не должно быть пустым")
    @Size(min = 2, max = 300, message = "Меню обеда должно быть от 2 до 100 символов длиной")
    private String snackName;

    @NotEmpty(message = "Состав снека не должен быть пустым")
    private String snackConsist;

    public SnackDTO() {
    }

    public SnackDTO(String snackName, String snackConsist) {
        this.snackName = snackName;
        this.snackConsist = snackConsist;
    }

    public @NotEmpty(message = "Название снека не должно быть пустым") @Size(min = 2, max = 300, message = "Меню обеда должно быть от 2 до 100 символов длиной") String getSnackName() {
        return snackName;
    }

    public void setSnackName(@NotEmpty(message = "Название снека не должно быть пустым") @Size(min = 2, max = 300, message = "Меню обеда должно быть от 2 до 100 символов длиной") String snackName) {
        this.snackName = snackName;
    }

    public @NotEmpty(message = "Состав снека не должен быть пустым") String getSnackConsist() {
        return snackConsist;
    }

    public void setSnackConsist(@NotEmpty(message = "Состав снека не должен быть пустым") String snackConsist) {
        this.snackConsist = snackConsist;
    }

    @Override
    public String toString() {
        return "{" +
                "snackName='" + snackName + '\'' +
                ", snackConsist='" + snackConsist + '\'' +
                '}';
    }
}
