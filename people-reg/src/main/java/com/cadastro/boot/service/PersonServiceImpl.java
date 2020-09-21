package com.cadastro.boot.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cadastro.boot.dao.PessoaDao;
import com.cadastro.boot.model.Person;

//anotação que torna a classe um Bean gerenciado pelo spring
@Service
@Transactional
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PessoaDao dao;

	@Override
	public void salvar(Person pessoa) {
		LocalDate hoje = LocalDate.now();
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		hoje.format(formatador);
		pessoa.setDataCadastro(hoje);
		dao.save(pessoa);
	}

	@Override
	public Person editar(Person pessoa) {
		LocalDate hoje = LocalDate.now();
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		hoje.format(formatador);
		pessoa.setDataAtualizacao(hoje);
		return dao.update(pessoa);
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Override
	@Transactional(readOnly = true) //não abrir uma nova transação
	public Person buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true) //não abrir uma nova transação
	public List<Person> buscarTodos() {
		return dao.findAll();
	}


}
