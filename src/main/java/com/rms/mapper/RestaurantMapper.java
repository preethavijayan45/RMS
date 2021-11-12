package com.rms.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

import com.rms.dto.RestaurantDto;
import com.rms.model.Restaurant;
import com.rms.model.RestaurantType;
import com.rms.service.RestaurantService;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class RestaurantMapper {

	@Autowired
	private RestaurantService restaurantService;

	@Mapping(source = "restaurantTypeId", target = "restaurantType", qualifiedByName = "restaurantTypeIdTorestaurantType")
	public abstract Restaurant restaurantDtoToRestaurant(RestaurantDto restaurantDto);

	@Named("restaurantTypeIdTorestaurantType")
	protected RestaurantType restaurantTypeIdTorestaurantType(Long restaurantTypeId) {
		return restaurantService.getRestaurantType(restaurantTypeId);
	}
}
