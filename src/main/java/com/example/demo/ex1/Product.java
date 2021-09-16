package com.example.demo.ex1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

	@Id @GeneratedValue
	private Long id;
	private String name;
	private int price;
	private int stockAmount;
	
}
