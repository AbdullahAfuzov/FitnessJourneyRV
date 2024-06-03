package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.dto.UsersExModelDTO;
import org.example.models.services.UsersExServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class UsersExController {

    private final UsersExServices usersExServices;

    @GetMapping("/getExUsers")
    public ResponseEntity<List<UsersExModelDTO>> getExUsersController() {

        List<UsersExModelDTO> exercisesUsers = usersExServices.getExUsers();

        return ResponseEntity.ok(exercisesUsers);
    }

    @PostMapping("/addExUser")
    public ResponseEntity<UsersExModelDTO> addNewExUsersController(@RequestBody UsersExModelDTO usersExModelDTO) {

        return ResponseEntity.ok(usersExServices.addNewExUsers(usersExModelDTO));
    }

    @DeleteMapping("/deleteExUser/{usersExDel}")
    public ResponseEntity<?> deleteExUsersController(@PathVariable String usersExDel) {

        usersExServices.deleteExUsers(usersExDel);
        return ResponseEntity.ok("DeleteOK");
    }
}
