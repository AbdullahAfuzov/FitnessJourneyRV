package org.example.mapper;

import org.example.dto.UsersExModelDTO;
import org.example.models.entities.UsersExModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsersExMapper {
    UsersExModelDTO usersExToUsersExDTO(UsersExModel usersExModel);
}
