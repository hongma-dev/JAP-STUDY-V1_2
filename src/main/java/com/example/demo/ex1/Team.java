package com.example.demo.ex1;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Team {

	@Id @GeneratedValue
	private Long id;
	private String name;
	
	@OneToMany(mappedBy="team")
	private List<Member> members = new ArrayList<Member>();
}
