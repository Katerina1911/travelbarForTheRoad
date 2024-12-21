package ru.bondarenko.travelbar.travelbarfortheroad.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.Cascade;
import ru.bondarenko.travelbar.travelbarfortheroad.DTO.DinnerDTO;

import java.time.LocalDateTime;
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

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "created_who")
    private String createdWho;

    public Country() {
    }

    public Country(String country) {
        this.country = country;
    }

    public @NotEmpty(message = "Название страны не должно быть пустым") @Size(min = 2, max = 100, message = " должно быть от 2 до 100 символов длиной") String getCountry() {
        return country;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCountry(@NotEmpty(message = "Название страны не должно быть пустым") @Size(min = 2, max = 100, message = " должно быть от 2 до 100 символов длиной") String country) {
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreatedWho() {
        return createdWho;
    }

    public void setCreatedWho(String createdWho) {
        this.createdWho = createdWho;
    }

    /** @JsonCreator
    public Country(@JsonProperty("cities") List<City> cities) {
        this.cities = cities;
    }*/

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", country='" + country + '\'' +
                '}';
    }

    // отношение с таблицей городов
    @OneToMany(mappedBy = "country", fetch = LAZY)
    @Cascade({org.hibernate.annotations.CascadeType.PERSIST,
            org.hibernate.annotations.CascadeType.REMOVE})
    private List<City> cities;

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    // отношение с таблицей обедов
    @OneToOne(mappedBy = "country", fetch = LAZY)
    private Dinner dinner;

    public Dinner getDinner() {
        return dinner;
    }

    public void setDinner(Dinner dinner) {
        this.dinner = dinner;
    }

    // отношение с таблицей настоек
    @OneToMany(mappedBy = "country", fetch = LAZY)
    @Cascade({org.hibernate.annotations.CascadeType.PERSIST,
            org.hibernate.annotations.CascadeType.REMOVE})
    private List<Drink> drinks;

    public List<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<Drink> drinks) {
        this.drinks = drinks;
    }

    // отношение с таблицей закусок
    @OneToMany(mappedBy = "country", cascade = CascadeType.PERSIST, fetch = LAZY)
    @Cascade({org.hibernate.annotations.CascadeType.PERSIST,
    org.hibernate.annotations.CascadeType.REMOVE})
    private List<Snack> snacks;

    public List<Snack> getSnacks() {
        return snacks;
    }

    public void setSnacks(List<Snack> snacks) {
        this.snacks = snacks;
    }

    /**@JsonCreator
    public Country (@JsonProperty("dinner") Dinner dinner) {
        this.dinner = dinner;
    }*/



}
