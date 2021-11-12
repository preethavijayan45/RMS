package com.rms.dto;

import lombok.Data;

@Data
public class MenuDto {

	private Long menuId;

	private String name;

	private Double price;

	private Long menuTypeId;

	private Long restaurantId;
}
