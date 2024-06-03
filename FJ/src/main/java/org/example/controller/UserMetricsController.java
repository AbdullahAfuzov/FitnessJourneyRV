package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.dto.UserMetricsModelDTO;
import org.example.models.services.UserMetricsServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class UserMetricsController {

    private final UserMetricsServices userMetricsServices;

    @GetMapping("/getMetrics")
    public ResponseEntity<List<UserMetricsModelDTO>> getUserMetricsController() {

        List<UserMetricsModelDTO> metrics = userMetricsServices.getUserMetrics();

        return ResponseEntity.ok(metrics);
    }

    @GetMapping("/getMetrics/{id}")
    public ResponseEntity<UserMetricsModelDTO> getUserMetricsById(@PathVariable int id){
        return ResponseEntity.ok(userMetricsServices.getUserMetricsById(id));
    }

    @PostMapping("/addMetrics")
    public ResponseEntity<UserMetricsModelDTO> addNewUserMetricsController(@RequestBody UserMetricsModelDTO userMetricsModelDTO) {

        return ResponseEntity.ok(userMetricsServices.addNewMetrics(userMetricsModelDTO));
    }

    @PutMapping("/updateMetrics/{id}")
    public ResponseEntity<UserMetricsModelDTO> updateMetricsController(@PathVariable int id,@RequestBody UserMetricsModelDTO userMetricsModelDTO) {

        return ResponseEntity.ok(userMetricsServices.updateMetrics(id, userMetricsModelDTO));
    }

    @DeleteMapping ("/deleteMetrics/{id}")
    public ResponseEntity<?> deleteUserMetricsController(@PathVariable String id) {

        userMetricsServices.deleteMetrics(id);

        return ResponseEntity.ok("DeleteOK");
    }
}
