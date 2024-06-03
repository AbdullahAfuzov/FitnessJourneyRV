package org.example.mapper;

import org.example.dto.ExerciseModelDTO;
import org.example.models.entities.ExerciseModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExerciseMapper {
    ExerciseModelDTO exerciseToExDTO(ExerciseModel exerciseModel);
}
