package com.rms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rms.model.Menu;
import com.rms.model.MenuType;
import com.rms.model.Restaurant;

public interface MenuRepository extends JpaRepository<Menu, Long> {

	public List<Menu> findByRestaurant(Restaurant restaurant);

	public List<Menu> findByMenuTypeAndRestaurant(MenuType menuType, Restaurant restaurant);
}
