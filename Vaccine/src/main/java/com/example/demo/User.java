package com.example.demo;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import org.springframework.stereotype.Component;


@Component
@Entity
public class User {


	@Id
	private String pid;
	private String prefix;
	@Column(nullable = false, length = 150)
	private String fname;
	@Column(nullable = false, length = 150)
	private String lname;
	private String birth_date;
	@Column(nullable = false, length = 150)
	private String tel;
	@Column(nullable = false)
	private String password;
	
	@OneToMany(mappedBy = "user")
	@OrderBy("register_id")
	private Set<Register> registers;

	public User() {
		super();
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Register> getRegisters() {
		return registers;
	}

	public void setRegisters(Set<Register> registers) {
		this.registers = registers;
	}

	

	
	
}
