package org.example.mapper;

import org.example.dto.UsersFoodModelDTO;
import org.example.models.entities.UsersFoodModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsersFoodMapper {
    UsersFoodModelDTO usersFoodToUsersFoodDTO(UsersFoodModel usersFoodModel);
}
