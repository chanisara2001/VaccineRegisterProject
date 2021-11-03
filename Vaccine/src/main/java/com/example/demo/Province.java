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
public class Province {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer province_id;
	@Column(nullable = false, length = 11)
	private Integer code;
	@Column(nullable = false, length = 150)
	private String name_in_thai;	
	@Column(nullable = false, length = 150)
	private String name_in_eng;
		
	public Province() {
		super();
	}

	@OneToMany(mappedBy = "province")
	@OrderBy("register_id")
	private Set<Register> registers;
	
	public Integer getProvince_id() {
		return province_id;
	}

	public void setProvince_id(Integer province_id) {
		this.province_id = province_id;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getName_in_thai() {
		return name_in_thai;
	}

	public void setName_in_thai(String name_in_thai) {
		this.name_in_thai = name_in_thai;
	}

	public String getName_in_eng() {
		return name_in_eng;
	}

	public void setName_in_eng(String name_in_eng) {
		this.name_in_eng = name_in_eng;
	}
	
	
	
}
