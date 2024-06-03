package org.example.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "exercise")
@Getter
@Setter
@NoArgsConstructor
public class ExerciseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "exerciseName", nullable = false, unique = true)
    private String exerciseName;

    @Column(name = "rep", nullable = false, unique = false)
    private int rep;

    @Column(name = "caloriesBurned", nullable = false, unique = false)
    private float caloriesBurned;

    public ExerciseModel(String exerciseName, int rep, float caloriesBurned) {
        this.exerciseName = exerciseName;
        this.rep = rep;
        this.caloriesBurned = caloriesBurned;
    }

}
