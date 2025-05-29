package com.example.dogservicenew.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.dogservicenew.dto.DogApiResponse;
import com.example.dogservicenew.entity.Dog;
import com.example.dogservicenew.repository.DogRepository;

@Service
public class DogService {

    @Value("${dog.api.url}")
    private String apiUrl;

    @Value("${dog.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;
    private final DogRepository dogRepository;

    public DogService(DogRepository dogRepository) {
        this.restTemplate = new RestTemplate();
        this.dogRepository = dogRepository;
    }

    public Dog fetchAndSaveRandomDog() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-api-key", apiKey);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<DogApiResponse[]> response = restTemplate.exchange(
                apiUrl + "/images/search",
                HttpMethod.GET,
                entity,
                DogApiResponse[].class
        );

        DogApiResponse[] responseBody = response.getBody();
        if (responseBody == null || responseBody.length == 0) {
            throw new RuntimeException("No dog image returned from API.");
        }

        DogApiResponse apiResponse = responseBody[0];

        Dog dog = new Dog();
        dog.setImageId(apiResponse.getId());
        dog.setImageUrl(apiResponse.getUrl());
        dog.setWidth(apiResponse.getWidth());
        dog.setHeight(apiResponse.getHeight());

        return dogRepository.save(dog);
    }

public String getRandomDogImage() {
    HttpHeaders headers = new HttpHeaders();
    headers.set("x-api-key", apiKey);
    HttpEntity<String> entity = new HttpEntity<>(headers);

    ResponseEntity<DogApiResponse[]> response = restTemplate.exchange(
            apiUrl + "/images/search",
            HttpMethod.GET,
            entity,
            DogApiResponse[].class
    );

    DogApiResponse[] responseBody = response.getBody();
    if (responseBody == null || responseBody.length == 0) {
        throw new RuntimeException("No dog image returned from API.");
    }

    return responseBody[0].getUrl(); // Return only the image URL
}
}












//@Service
//public class DogService {
//
//    @Value("${dog.api.url}")
//    private String apiUrl;
//
//    @Value("${dog.api.key}")
//    private String apiKey;
//
//    private final RestTemplate restTemplate;
//    private final DogRepository dogRepository;
//
//    public DogService(DogRepository dogRepository) {
//        this.restTemplate = new RestTemplate();
//        this.dogRepository = dogRepository;
//    }
//
//    public Dog fetchAndSaveRandomDog() {
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("x-api-key", apiKey);
//        HttpEntity<String> entity = new HttpEntity<>(headers);
//        
//        
//        
//        
//        ResponseEntity<String> response = restTemplate.exchange(
//              apiUrl + "/images/search",
//              HttpMethod.GET,
//              entity,
//              String.class
//      );
//
//      return response.getBody();
//
//        ResponseEntity<DogApiResponse[]> response = restTemplate.exchange(
//                apiUrl + "/images/search",
//                HttpMethod.GET,
//                entity,
//                DogApiResponse[].class
//        );
//
//        DogApiResponse apiResponse = response.getBody()[0];
//
//        Dog dog = new Dog();
//        dog.setImageId(apiResponse.getId());
//        dog.setImageUrl(apiResponse.getUrl());
//        dog.setWidth(apiResponse.getWidth());
//        dog.setHeight(apiResponse.getHeight());
//
//        return dogRepository.save(dog);
//    }
//}




//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//@Service
//public class DogService {
//    @Value("${dog.api.url}")
//    private String apiUrl;
//
//    @Value("${dog.api.key}")
//    private String apiKey;
//
//    private final RestTemplate restTemplate = new RestTemplate();
//
//    public String getRandomDogImage() {
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("x-api-key", apiKey);
//        HttpEntity<String> entity = new HttpEntity<>(headers);
//
//        ResponseEntity<String> response = restTemplate.exchange(
//                apiUrl + "/images/search",
//                HttpMethod.GET,
//                entity,
//                String.class
//        );
//
//        return response.getBody();



//    }
//}
