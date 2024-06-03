package org.example.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class UserMetricsModelDTO {
    private int id;

    private float kilograms;

    private float centimeters;

    private int age;

    private String gender;

    private double caloriesBM;
}
