package org.example.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "userMetrics")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserMetricsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "kilograms", nullable = false, unique = false)
    private float kilograms;

    @Column(name = "centimeters", nullable = false, unique = false)
    private float centimeters;

    @Column(name = "age", nullable = false, unique = false)
    private int age;

    @Column(name = "gender", nullable = false, unique = false)
    private String gender;

    @Column(name = "caloriesBM", nullable = false, unique = false)
    private double caloriesBM;

    public UserMetricsModel(float kilograms, float centimeters, int age, String gender, double caloriesBM) {
        this.kilograms = kilograms;
        this.centimeters = centimeters;
        this.age = age;
        this.gender = gender;
        this.caloriesBM = caloriesBM;
    }
}
