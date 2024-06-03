package org.example.models.services;

import lombok.AllArgsConstructor;
import org.example.dto.FoodModelDTO;
import org.example.mapper.FoodMapper;
import org.example.models.entities.FoodModel;
import org.example.repositories.FoodRepository;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class FoodServices {
    private final FoodRepository foodRepository;
    private final FoodMapper foodMapper;

    public List<FoodModelDTO> getFoods(){
        List<FoodModelDTO> foodModelDTOS = new ArrayList<>();
        for (FoodModel foodModel : foodRepository.findAll()) {
            foodModelDTOS.add(foodMapper.foodToFoodDTO(foodModel));
        }

        return foodModelDTOS;
    }
    public FoodModelDTO getFood(String foodName){
        for (FoodModel foodModel : foodRepository.findAll()) {
            if (foodModel.getFoodName().equals(foodName)){
                return foodMapper.foodToFoodDTO(foodModel);
            }
        }

        return null;
    }

    public FoodModelDTO addNewFood(FoodModelDTO foodModelDTO) {
        FoodModel foodModel = new FoodModel(
                foodModelDTO.getFoodName(),
                foodModelDTO.getGrams(),
                foodModelDTO.getCalories()
        );

        return foodMapper.foodToFoodDTO(foodRepository.save(foodModel));
    }

    public FoodModelDTO updateFood(FoodModelDTO foodModelDTO) {
        FoodModel foodModel = new FoodModel(
                foodModelDTO.getFoodName(),
                foodModelDTO.getGrams(),
                foodModelDTO.getCalories()
        );
        return foodMapper.foodToFoodDTO(foodRepository.save(foodModel));
    }

    public void deleteFood(String foodDel) {
        Integer id = foodRepository.findFoodModelByFoodName(foodDel);

        foodRepository.deleteById(id);
    }
}
