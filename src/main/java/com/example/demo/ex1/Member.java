package com.example.demo.ex1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {

	@Id @GeneratedValue
	private Long id;
	private String userName;
	private int age;
	
	@ManyToOne
	@JoinColumn(name="TEAM_ID")
	private Team team;
}
