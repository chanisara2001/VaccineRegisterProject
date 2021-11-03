package com.example.demo;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Vaccine {
	@Id
	private String vaccine_id;
	@Column(nullable = false, length = 150)
	private String name;
	
	@OneToMany(mappedBy = "vaccine")
	@OrderBy("register_id")
	private Set<Register> registers;
	
	public Vaccine() {
		super();
	}
	public String getVaccine_id() {
		return vaccine_id;
	}
	public void setVaccine_id(String vaccine_id) {
		this.vaccine_id = vaccine_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
