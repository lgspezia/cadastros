package com.cadastro.boot.service;

import java.util.List;

import com.cadastro.boot.model.Person;

public interface PersonService {
	
	void salvar(Person pessoa);
	
	Person editar(Person pessoa);
	
	void excluir(Long id);
	
	Person buscarPorId(Long id);
	
	List<Person> buscarTodos();

}
