package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Register {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer register_id;
	@Column(nullable = false,length = 30)
	private String status;
	@Column(nullable = false)
	private String date;
	@Column(nullable = false)
	private Integer dose;
	
	@ManyToOne
	@JoinColumn(name = "pid", nullable = false)
	private User user;	
	
	@ManyToOne
	@JoinColumn(name = "vaccine_id", nullable = false)
	private Vaccine vaccine;	
	
	@ManyToOne
	@JoinColumn(name = "province_id", nullable = false)
	private Province province;	
	public Integer getRegister_id() {
		return register_id;
	}

	public void setRegister_id(Integer register_id) {
		this.register_id = register_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getDose() {
		return dose;
	}

	public void setDose(Integer dose) {
		this.dose = dose;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Vaccine getVaccine() {
		return vaccine;
	}

	public void setVaccine(Vaccine vaccine) {
		this.vaccine = vaccine;
	}

	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}


	
	
	
}
