package org.example.repositories;

import org.example.models.entities.UsersExModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersExRepository extends CrudRepository<UsersExModel, Integer> {

    Integer findUsersExModelByUserExerciseName(String usersExDel);
}

