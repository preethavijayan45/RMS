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
@Table(name = "menu_type", schema = "master")
public class MenuType implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7234157142122886658L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "menu_type_id")
	private Long menuTypeId;

	@Column(name = "name")
	private String name;

}
