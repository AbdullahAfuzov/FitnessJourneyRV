package org.example.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users-food")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UsersFoodModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, unique = false)
    private String usersFoodName;

    @Column(name = "users-grams", nullable = false, unique = false)
    private float usersGrams;

    @Column(name = "calories", nullable = false, unique = false)
    private float calories;

    public UsersFoodModel(String name, float usersGrams, float calories) {
        this.usersFoodName = name;
        this.usersGrams = usersGrams;
        this.calories = calories;
    }
}
