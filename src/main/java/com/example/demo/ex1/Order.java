package com.example.demo.ex1;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="ORDERS")
public class Order {

	@Id @GeneratedValue
	private Long id;
	private int orderAmount;
	
	@Embedded
	private Address address;
	
	@ManyToOne
	@JoinColumn(name="PRODUCT_ID")
	private Product product;
}
