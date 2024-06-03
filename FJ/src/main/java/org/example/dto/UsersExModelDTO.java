package org.example.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class UsersExModelDTO {

    private int id;

    private String userExerciseName;

    private int rep;

    private int caloriesBurned;
}
