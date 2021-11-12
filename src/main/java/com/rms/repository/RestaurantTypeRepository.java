package com.rms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rms.model.RestaurantType;

public interface RestaurantTypeRepository extends JpaRepository<RestaurantType, Long> {

}
