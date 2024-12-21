package ru.bondarenko.travelbar.travelbarfortheroad.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "menu_bar")
public class Drink {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Название настойки не должно быть пустым")
    @Size(min = 2, max = 100, message = "Название настойки должно быть от 2 до 100 символов длиной")
    @Column(name = "drink_name")
    private String drinkName;

    @NotEmpty(message = "Состав настойки не должен быть пустым")
    @Column(name = "drink_consist")
    private String drinkConsist;

    public Drink() {
    }

    public Drink(String drinkName, String drinkConsist) {
        this.drinkName = drinkName;
        this.drinkConsist = drinkConsist;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "Drink{" +
                "drinkName='" + drinkName + '\'' +
                ", drinkConsist='" + drinkConsist + '\'' +
                '}';
    }

    // отношения с таблицей стран
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

    // отношение с таблицей городов
    @ManyToOne
    @JoinColumn (name = "city_id", referencedColumnName = "id")
    private City city;

    @JsonIgnore
    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
