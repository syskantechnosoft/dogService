package com.example.dogservicenew.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dogservicenew.entity.Dog;

@Repository
public interface DogRepository extends JpaRepository<Dog, Long> {
}