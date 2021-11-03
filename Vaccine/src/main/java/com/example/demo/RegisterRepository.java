package com.example.demo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface RegisterRepository extends CrudRepository<Register, Integer> {
	List<Register> findByUser(User user);
}
