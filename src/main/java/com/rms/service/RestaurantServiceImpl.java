package com.rms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rms.model.Menu;
import com.rms.model.MenuType;
import com.rms.model.Restaurant;
import com.rms.model.RestaurantType;
import com.rms.repository.MenuRepository;
import com.rms.repository.MenuTypeRepository;
import com.rms.repository.RestaurantRepository;
import com.rms.repository.RestaurantTypeRepository;

@Service
@Transactional
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private RestaurantRepository restaurantRepository;

	@Autowired
	private RestaurantTypeRepository restaurantTypeRepository;

	@Autowired
	private MenuRepository menuRepository;

	@Autowired
	private MenuTypeRepository menuTypeRepository;

	@Override
	public Restaurant saveRestaurant(Restaurant restaurant) {

		return restaurantRepository.save(restaurant);
	}

	@Override
	public List<Restaurant> listRestaurant() {

		return restaurantRepository.findAll();
	}

	@Override
	public RestaurantType getRestaurantType(Long restaurantTypeId) {

		return restaurantTypeId != null ? restaurantTypeRepository.findById(restaurantTypeId).orElse(null) : null;
	}

	@Override
	public List<RestaurantType> listRestaurantType() {

		return restaurantTypeRepository.findAll();
	}

	@Override
	public List<MenuType> listMenuType() {

		return menuTypeRepository.findAll();
	}

	@Override
	public MenuType getMenuType(Long menuTypeId) {

		return menuTypeId != null ? menuTypeRepository.findById(menuTypeId).orElse(null) : null;
	}

	@Override
	public List<Menu> listMenu(Restaurant restaurant) {

		return menuRepository.findByRestaurant(restaurant);
	}

	@Override
	public List<Menu> listMenu(Restaurant restaurant, MenuType menuType) {

		return menuRepository.findByMenuTypeAndRestaurant(menuType, restaurant);
	}

	@Override
	public Restaurant getRestaurant(Long restaurantId) {

		return restaurantId != null ? restaurantRepository.findById(restaurantId).orElse(null) : null;
	}

	@Override
	public Menu saveMenu(Menu menu) {

		return menuRepository.save(menu);
	}
}
