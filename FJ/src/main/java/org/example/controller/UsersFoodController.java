package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.dto.UsersFoodModelDTO;
import org.example.models.services.UsersFoodServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class UsersFoodController {

    private final UsersFoodServices usersFoodServices;

    @GetMapping("/getFoodUsers")
    public ResponseEntity<List<UsersFoodModelDTO>> getFoodUsersController() {

        List<UsersFoodModelDTO> foodUsers = usersFoodServices.getFoodUsers();

        return ResponseEntity.ok(foodUsers);
    }

    @PostMapping("/addFoodUser")
    public ResponseEntity<UsersFoodModelDTO> addNewFoodUsersController(@RequestBody UsersFoodModelDTO usersFoodModelDTO) {

        return ResponseEntity.ok(usersFoodServices.addNewFoodUsers(usersFoodModelDTO));
    }

    @DeleteMapping("/deleteFoodUser/{usersFoodDel}")
    public ResponseEntity<?> deleteFoodUsersController(@PathVariable String usersFoodDel) {

        usersFoodServices.deleteFoodUsers(usersFoodDel);
        return ResponseEntity.ok("DeleteOK");
    }
}
