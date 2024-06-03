package org.example.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ExerciseModelDTO {

    private String exerciseName;

    private int rep;

    private float caloriesBurned;
}
