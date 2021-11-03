package com.example.demo;

import java.sql.DriverManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import com.sun.jdi.connect.spi.Connection;
@SpringBootApplication
public class VaccineApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(VaccineApplication.class, args);
	}
	

}
