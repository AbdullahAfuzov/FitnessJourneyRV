package org.example.models.services;

import lombok.AllArgsConstructor;
import org.example.dto.ExerciseModelDTO;
import org.example.dto.UsersExModelDTO;
import org.example.mapper.UsersExMapper;
import org.example.models.entities.UsersExModel;
import org.example.repositories.UsersExRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UsersExServices {
    private final UsersExRepository usersExRepository;
    private final UsersExMapper usersExMapper;
    private final ExerciseServices exerciseServices;

    public List<UsersExModelDTO> getExUsers(){

        List<UsersExModelDTO> usersExModelDTOS = new ArrayList<>();
        for (UsersExModel usersExModel : usersExRepository.findAll()) {
            usersExModelDTOS.add(usersExMapper.usersExToUsersExDTO(usersExModel));
        }

        return usersExModelDTOS;
    }

    public UsersExModelDTO addNewExUsers(UsersExModelDTO usersExModelDTO) {
        ExerciseModelDTO exercise = this.exerciseServices.getExercise(usersExModelDTO.getUserExerciseName());
        float calories = ((float) usersExModelDTO.getRep() / exercise.getRep()) * exercise.getCaloriesBurned();
        UsersExModel usersExModel = new UsersExModel(
                usersExModelDTO.getUserExerciseName(),
                usersExModelDTO.getRep(),
                calories
        );

        return usersExMapper.usersExToUsersExDTO(usersExRepository.save(usersExModel));
    }

    public void deleteExUsers(String id){

        Integer exUserId = Integer.parseInt(id);

        usersExRepository.deleteById(exUserId);
    }
}
