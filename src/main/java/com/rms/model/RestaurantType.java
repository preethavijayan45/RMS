package com.rms.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "restaurant_type", schema = "master")
public class RestaurantType implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = -4043812917482863152L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "restaurant_type_id")
	private Long restaurantTypeId;

	@Column(name = "name")
	private String name;

}
