package com.example.demo.ex1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(
		name="Member.findByUserName",
		query="select m from Member m where m.userName = :userName"
		)
public class Member {

	@Id @GeneratedValue
	private Long id;
	private String userName;
	private int age;
	
	@ManyToOne
	@JoinColumn(name="TEAM_ID")
	private Team team;
}
