package com.rms.dto;

import lombok.Data;

@Data
public class RestaurantDto {
	
	private Long restaurantId;

	private String name;

	private String address;

	private String phone;

	private Long restaurantTypeId;
}
