package org.example.mapper;

import org.example.dto.UserMetricsModelDTO;
import org.example.models.entities.UserMetricsModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMetricsMapper {
    UserMetricsModelDTO userMetricsToUserMetricsDTO(UserMetricsModel userMetricsModel);
}
