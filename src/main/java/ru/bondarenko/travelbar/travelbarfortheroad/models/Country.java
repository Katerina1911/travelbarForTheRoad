package ru.bondarenko.travelbar.travelbarfortheroad.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import ru.bondarenko.travelbar.travelbarfortheroad.DTO.CityDTO;

import java.util.List;

import static jakarta.persistence.FetchType.LAZY;


@Entity
@Table (name = "country")
public class Country {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Название страны не должно быть пустым")
    @Size(min = 2, max = 100, message = "Название страны должно быть от 2 до 100 символов длиной")
    @Column(name = "country")
    private String country;

    @OneToMany(mappedBy = "country", fetch = LAZY)
    private List<City> cities;

    public Country() {
    }

    public Country(String country) {
        this.country = country;
    }

    public @NotEmpty(message = "Название страны не должно быть пустым") @Size(min = 2, max = 100, message = " должно быть от 2 до 100 символов длиной") String getCountry() {
        return country;
    }

    public void setCountry(@NotEmpty(message = "Название страны не должно быть пустым") @Size(min = 2, max = 100, message = " должно быть от 2 до 100 символов длиной") String country) {
        this.country = country;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", country='" + country + '\'' +
                '}';
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}
