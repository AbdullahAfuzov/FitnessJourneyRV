package org.example.models.services;

import lombok.AllArgsConstructor;
import org.example.dto.ExerciseModelDTO;
import org.example.mapper.ExerciseMapper;
import org.example.models.entities.ExerciseModel;
import org.example.repositories.ExerciseRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ExerciseServices {
    private final ExerciseRepository exerciseRepository;
    private final ExerciseMapper exerciseMapper;

    public List<ExerciseModelDTO> getExercises(){
        List<ExerciseModelDTO> exerciseModelDTOS = new ArrayList<>();
        for (ExerciseModel exerciseModel : exerciseRepository.findAll()) {
            exerciseModelDTOS.add(exerciseMapper.exerciseToExDTO(exerciseModel));
        }

        return exerciseModelDTOS;
    }
    public ExerciseModelDTO getExercise(String exerciseName){
        for (ExerciseModel exerciseModel : exerciseRepository.findAll()) {
            if (exerciseModel.getExerciseName().equals(exerciseName)){
                return exerciseMapper.exerciseToExDTO(exerciseModel);
            }
        }

        return null;
    }

    public ExerciseModelDTO addNewExercise(ExerciseModelDTO exerciseModelDTO) {
        ExerciseModel exerciseModel = new ExerciseModel(
                exerciseModelDTO.getExerciseName(),
                exerciseModelDTO.getRep(),
                exerciseModelDTO.getCaloriesBurned()
        );

        return exerciseMapper.exerciseToExDTO(exerciseRepository.save(exerciseModel));
    }

    public ExerciseModelDTO updateExercise(ExerciseModelDTO exerciseModelDTO) {
        ExerciseModel exerciseModel = new ExerciseModel(
                exerciseModelDTO.getExerciseName(),
                exerciseModelDTO.getRep(),
                exerciseModelDTO.getCaloriesBurned()
        );
        return exerciseMapper.exerciseToExDTO(exerciseRepository.save(exerciseModel));
    }

    public void deleteExercise(String exNameDel) {
        Integer id = exerciseRepository.findExerciseModelByExerciseName(exNameDel);

        exerciseRepository.deleteById(id);
    }
}
