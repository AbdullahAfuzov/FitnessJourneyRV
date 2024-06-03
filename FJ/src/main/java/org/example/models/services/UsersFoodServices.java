package org.example.models.services;

import lombok.AllArgsConstructor;
import org.example.dto.FoodModelDTO;
import org.example.dto.UsersFoodModelDTO;
import org.example.mapper.UsersFoodMapper;
import org.example.models.entities.UsersFoodModel;
import org.example.repositories.UsersFoodRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UsersFoodServices {
    private final UsersFoodRepository usersFoodRepository;
    private final UsersFoodMapper usersFoodMapper;
    private final FoodServices foodServices;

    public List<UsersFoodModelDTO> getFoodUsers(){

        List<UsersFoodModelDTO> usersFoodModelDTOS = new ArrayList<>();
        for (UsersFoodModel usersFoodModel : usersFoodRepository.findAll()) {
            usersFoodModelDTOS.add(usersFoodMapper.usersFoodToUsersFoodDTO(usersFoodModel));
        }

        return usersFoodModelDTOS;
    }

    public UsersFoodModelDTO addNewFoodUsers(UsersFoodModelDTO usersFoodModelDTO) {
        FoodModelDTO food = this.foodServices.getFood(usersFoodModelDTO.getUsersFoodName());
        float calories = (usersFoodModelDTO.getUsersGrams()/ food.getGrams()) * food.getCalories();
        UsersFoodModel usersFoodModel = new UsersFoodModel(
                usersFoodModelDTO.getUsersFoodName(),
                usersFoodModelDTO.getUsersGrams(),
                calories
        );

        return usersFoodMapper.usersFoodToUsersFoodDTO(usersFoodRepository.save(usersFoodModel));
    }

    public void deleteFoodUsers(String id){

        Integer usersFoodId = Integer.parseInt(id);

        usersFoodRepository.deleteById(usersFoodId);
    }
}
