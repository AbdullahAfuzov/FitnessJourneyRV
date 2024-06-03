package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.dto.FoodModelDTO;
import org.example.models.services.FoodServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class FoodController {

    private final FoodServices foodServices;

    @GetMapping("/getFoods")
    public ResponseEntity<List<FoodModelDTO>> getFoodController() {

        List<FoodModelDTO> foods = foodServices.getFoods();

        return ResponseEntity.ok(foods);
    }

   @PostMapping("/addFood")
    public ResponseEntity<FoodModelDTO> addNewFoodController(@RequestBody FoodModelDTO foodModelDTO) {

       return ResponseEntity.ok(foodServices.addNewFood(foodModelDTO));
    }

    @PutMapping("/updateFood")
    public ResponseEntity<FoodModelDTO> updateFoodController(@RequestBody FoodModelDTO foodModelDTO) {

       return ResponseEntity.ok(foodServices.updateFood(foodModelDTO));
    }

    @DeleteMapping("/deleteFood/{foodDel}")
    public ResponseEntity<?> deleteFoodController(@PathVariable String foodDel) {

       foodServices.deleteFood(foodDel);
       return ResponseEntity.ok("DeleteOK");
    }

}
