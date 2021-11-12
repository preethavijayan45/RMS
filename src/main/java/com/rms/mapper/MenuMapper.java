package com.rms.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

import com.rms.dto.MenuDto;
import com.rms.model.Menu;
import com.rms.model.MenuType;
import com.rms.model.Restaurant;
import com.rms.service.RestaurantService;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class MenuMapper {

	@Autowired
	private RestaurantService restaurantService;

	@Mapping(source = "restaurantId", target = "restaurant", qualifiedByName = "restaurantIdToRestaurant")
	@Mapping(source = "menuTypeId", target = "menuType", qualifiedByName = "menuTypeIdToMenuType")
	public abstract Menu menuDtoToMenu(MenuDto menuDto);

	@Named("restaurantIdToRestaurant")
	protected Restaurant restaurantIdToRestaurant(Long restaurantId) {
		return restaurantService.getRestaurant(restaurantId);
	}

	@Named("menuTypeIdToMenuType")
	protected MenuType menuTypeIdToMenuType(Long menuTypeId) {
		return restaurantService.getMenuType(menuTypeId);
	}

}
