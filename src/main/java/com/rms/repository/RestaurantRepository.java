package com.rms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rms.model.Restaurant;


public interface RestaurantRepository extends JpaRepository<Restaurant, Long>{

}
