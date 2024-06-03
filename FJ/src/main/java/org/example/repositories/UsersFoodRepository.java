package org.example.repositories;

import org.example.models.entities.UsersFoodModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersFoodRepository extends CrudRepository<UsersFoodModel, Integer> {

    Integer findUsersFoodModelByUsersFoodName(String usersFoodDel);
}

