package com.etiya.rentACarSpring.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cars")
public class Car {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "brandId")
	private int brandId;
	
	@Column(name = "colorId")
	private int colorId;
	
	@Column(name = "modelYear")
	private int modelYear;
	
	@Column(name = "dailyPrice")
	private int dailyPrice;
	
	@Column(name = "description")
	private String description;

}
