package com.example.dogservicenew.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dogservicenew.entity.Dog;
import com.example.dogservicenew.service.DogService;

@RestController
@RequestMapping("/dogs")
public class DogController {

    private final DogService dogService;

    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    @PostMapping("/fetch-save")
    public ResponseEntity<Dog> fetchAndSaveDog() {
        Dog savedDog = dogService.fetchAndSaveRandomDog();
        return ResponseEntity.ok(savedDog);
    }
    
    @GetMapping("/random")
  public ResponseEntity<String> getRandomDog() {
      return ResponseEntity.ok(dogService.getRandomDogImage());
  }
    
    
    
}




//@RestController
//@RequestMapping("/dogs")
//public class DogController {
//
//    private final DogService dogService;
//
//    public DogController(DogService dogService) {
//        this.dogService = dogService;
//    }
//
//    @GetMapping("/random")
//    public ResponseEntity<String> getRandomDog() {
//        return ResponseEntity.ok(dogService.getRandomDogImage());
//    }
//}
