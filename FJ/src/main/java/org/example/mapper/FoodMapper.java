package org.example.mapper;

import org.example.dto.FoodModelDTO;
import org.example.models.entities.FoodModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FoodMapper {
    FoodModelDTO foodToFoodDTO(FoodModel foodModel);
}
