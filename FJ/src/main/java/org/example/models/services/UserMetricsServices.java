package org.example.models.services;

import lombok.AllArgsConstructor;
import org.example.dto.UserMetricsModelDTO;
import org.example.mapper.UserMetricsMapper;
import org.example.models.entities.UserMetricsModel;
import org.example.repositories.UserMetricsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserMetricsServices {

    private final UserMetricsRepository userMetricsRepository;
    private final UserMetricsMapper userMetricsMapper;

    public List<UserMetricsModelDTO> getUserMetrics() {
        List<UserMetricsModelDTO> userMetricsModelDTOS = new ArrayList<>();
        for (UserMetricsModel userMetricsModel : userMetricsRepository.findAll()) {
            userMetricsModelDTOS.add(userMetricsMapper.userMetricsToUserMetricsDTO(userMetricsModel));
        }

        return userMetricsModelDTOS;
    }

    public UserMetricsModelDTO getUserMetricsById(int id) {
        return userMetricsMapper.userMetricsToUserMetricsDTO(userMetricsRepository.findById(id).orElse(null));
    }

    public UserMetricsModelDTO addNewMetrics(UserMetricsModelDTO userMetricsModelDTO) {
        int index = 0;
        if(userMetricsModelDTO.getGender().equals("M")) {
            index = 5;
        } else {
            index = -161;
        }
        double calories = ((10 * userMetricsModelDTO.getKilograms()) + (6.25 * userMetricsModelDTO.getCentimeters()) - (5 * userMetricsModelDTO.getAge()) + index) * 1.4;
        UserMetricsModel userMetricsModel = new UserMetricsModel(
                userMetricsModelDTO.getKilograms(),
                userMetricsModelDTO.getCentimeters(),
                userMetricsModelDTO.getAge(),
                userMetricsModelDTO.getGender(),
                calories
        );

        return userMetricsMapper.userMetricsToUserMetricsDTO(userMetricsRepository.save(userMetricsModel));
    }

    public UserMetricsModelDTO updateMetrics(int id, UserMetricsModelDTO userMetricsModelDTO) {
        Optional<UserMetricsModel> existingUser = userMetricsRepository.findById(id);

        if (existingUser.isPresent()) {
            int index = 0;
            if(userMetricsModelDTO.getGender().equals("M")) {
                index = 5;
            } else {
                index = -161;
            }
            double calories = ((10 * userMetricsModelDTO.getKilograms()) + (6.25 * userMetricsModelDTO.getCentimeters()) - (5 * userMetricsModelDTO.getAge()) + index) * 1.4;
            UserMetricsModel userMetricsModel = new UserMetricsModel(
                    userMetricsModelDTO.getKilograms(),
                    userMetricsModelDTO.getCentimeters(),
                    userMetricsModelDTO.getAge(),
                    userMetricsModelDTO.getGender(),
                    calories
            );

            return userMetricsMapper.userMetricsToUserMetricsDTO(userMetricsRepository.save(userMetricsModel));
        }else {
            throw new IllegalArgumentException();
        }
    }

    public void deleteMetrics(String id) {

        Integer metricsId = Integer.parseInt(id);

        userMetricsRepository.deleteById(metricsId);
    }
}
