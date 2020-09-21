package com.cadastro.boot.dao;

import java.util.List;

import com.cadastro.boot.model.Person;

public interface PessoaDao {

	void save(Person pessoa);
	Person update(Person pessoa);
	void delete(Long id);
	Person findById(Long id);
	List<Person> findAll();
}
