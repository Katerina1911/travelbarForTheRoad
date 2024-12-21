package ru.bondarenko.travelbar.travelbarfortheroad.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "menu_snack")
public class Snack {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Название снека не должно быть пустым")
    @Size(min = 2, max = 300, message = "Меню обеда должно быть от 2 до 100 символов длиной")
    @Column(name = "snack_name")
    private String snackName;

    @NotEmpty(message = "Состав снека не должен быть пустым")
    @Column(name = "snack_consist")
    private String snackConsist;

    public Snack() {
    }

    public Snack(String snackName, String snackConsist) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Snack{" +
                "id=" + id +
                ", snackName='" + snackName + '\'' +
                ", snackConsist='" + snackConsist + '\'' +
                '}';
    }

    @ManyToOne
    @JoinColumn (name = "country_id", referencedColumnName = "id")
    private Country country;

    @JsonIgnore               // надо ли
    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
