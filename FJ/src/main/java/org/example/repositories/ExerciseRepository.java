package org.example.repositories;

import org.example.models.entities.ExerciseModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepository extends CrudRepository<ExerciseModel, Integer> {

    Integer findExerciseModelByExerciseName(String exNameDel);

}
