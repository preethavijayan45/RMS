package com.rms.service;

import java.util.List;

import com.rms.model.Menu;
import com.rms.model.MenuType;
import com.rms.model.Restaurant;
import com.rms.model.RestaurantType;

public interface RestaurantService {

	public Restaurant saveRestaurant(Restaurant restaurant);

	public Restaurant getRestaurant(Long restaurantId);

	public List<Restaurant> listRestaurant();

	public RestaurantType getRestaurantType(Long restaurantTypeId);

	public List<RestaurantType> listRestaurantType();

	public List<MenuType> listMenuType();

	public MenuType getMenuType(Long menuTypeId);

	public List<Menu> listMenu(Restaurant restaurant);

	public List<Menu> listMenu(Restaurant restaurant, MenuType menuType);

	public Menu saveMenu(Menu menu);
}
