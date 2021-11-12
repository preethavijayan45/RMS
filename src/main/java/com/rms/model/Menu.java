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
@Table(name = "menu", schema = "restaurant")
public class Menu implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 3151535410956759377L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "menu_id")
	private Long menuId;

	@Column(name = "name")
	private String name;

	@Column(name = "price")
	private Double price;

	@Column(name = "ingredients")
	private String ingredients;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "restaurant_id", referencedColumnName = "restaurant_id")
	private Restaurant restaurant;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "menu_type_id", referencedColumnName = "menu_type_id")
	private MenuType menuType;

}
