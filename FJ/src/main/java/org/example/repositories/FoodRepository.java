package org.example.repositories;

import org.example.models.entities.FoodModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends CrudRepository<FoodModel, Integer> {

    Integer findFoodModelByFoodName(String foodDel);
}
