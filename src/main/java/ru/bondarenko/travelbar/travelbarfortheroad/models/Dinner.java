package ru.bondarenko.travelbar.travelbarfortheroad.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.util.List;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Table (name = "menu_dinner")
public class Dinner {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Меню обеда не должно быть пустым")
    @Size(min = 2, max = 300, message = "Меню обеда должно быть от 2 до 100 символов длиной")
    @Column(name = "dinner_name")
    private String dinnerName;

    @NotEmpty(message = "Состав обеда не должен быть пустым")
    @Column(name = "dinner_consist")
    private String dinnerConsist;

    public Dinner() {
    }

    public Dinner(String dinnerConsist, String dinnerName) {
        this.dinnerConsist = dinnerConsist;
        this.dinnerName = dinnerName;
    }

    @OneToOne
    @JoinColumn (name = "country_id", referencedColumnName = "id")
    private Country country;

    @JsonIgnore    // надо ли
    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Dinner{" +
                "id=" + id +
                ", dinnerName='" + dinnerName + '\'' +
                ", dinnerConsist='" + dinnerConsist + '\'' +
              //  ", country=" + country +
                '}';
    }
}
