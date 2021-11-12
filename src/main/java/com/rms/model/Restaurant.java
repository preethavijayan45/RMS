package com.rms.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "restaurant", schema = "restaurant")
public class Restaurant implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = -766829794942448782L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "restaurant_id")
	private Long restaurantId;

	@Column(name = "name")
	private String name;

	@Column(name = "address")
	private String address;

	@Column(name = "phone")
	private String phone;

	@Column(name = "open_status")
	private Boolean openStatus;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "restaurant_type_id", referencedColumnName = "restaurant_type_id")
	private RestaurantType restaurantType;
}
