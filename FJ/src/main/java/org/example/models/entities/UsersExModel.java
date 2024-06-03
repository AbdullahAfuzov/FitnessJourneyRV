package org.example.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users-exercise")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UsersExModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user-exercise-name", nullable = false, unique = false)
    private String userExerciseName;

    @Column(name = "users-rep", nullable = false, unique = false)
    private int rep;

    @Column(name = "caloriesBurned", nullable = false, unique = false)
    private float caloriesBurned;

    public UsersExModel(String exerciseName, int rep, float caloriesBurned) {
        this.userExerciseName = exerciseName;
        this.rep = rep;
        this.caloriesBurned = caloriesBurned;
    }
}
