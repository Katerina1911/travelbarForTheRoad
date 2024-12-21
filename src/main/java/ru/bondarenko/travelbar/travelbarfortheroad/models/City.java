package ru.bondarenko.travelbar.travelbarfortheroad.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.Cascade;

import java.util.List;

import static jakarta.persistence.FetchType.LAZY;


@Entity
@Table(name = "City")
public class City {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Название города не должно быть пустым")
    @Size(min = 2, max = 100, message = "Название города должно быть от 2 до 100 символов длиной")
    @Column(name = "city")
    private String city;

    public City() {
    }

    public City(String city) {
        this.city = city;
    }

    /**@Column(name = "country_id")
    @NotEmpty(message = "Название страны не должно быть пустым")
    private int country_id;*/

    public @NotEmpty(message = "Название города не должно быть пустым") @Size(min = 2, max = 100, message = "Название города должно быть от 2 до 100 символов длиной") String getCity() {
        return city;
    }

    public void setCity(@NotEmpty(message = "Название города не должно быть пустым") @Size(min = 2, max = 100, message = "Название города должно быть от 2 до 100 символов длиной") String city) {
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", country=" + country +
                '}';
    }

    // отношение с таблицей стран
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

    // отношение с таблицей настоек
    @OneToMany(mappedBy = "city", fetch = LAZY)
    @Cascade({org.hibernate.annotations.CascadeType.PERSIST,
            org.hibernate.annotations.CascadeType.REMOVE})
    private List<Drink> drinks;

    public List<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<Drink> drinks) {
        this.drinks = drinks;
    }
}
