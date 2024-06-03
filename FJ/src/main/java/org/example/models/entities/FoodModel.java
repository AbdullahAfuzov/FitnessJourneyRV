package org.example.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "food")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class FoodModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, unique = true)
    private String foodName;

    @Column(name = "grams", nullable = false, unique = false)
    private float grams;

    @Column(name = "calories", nullable = false, unique = false)
    private float calories;

    public FoodModel(String name, float grams, float calories) {
        this.foodName = name;
        this.grams = grams;
        this.calories = calories;
    }
}

