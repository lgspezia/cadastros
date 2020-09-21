package com.cadastro.boot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cadastro.boot.model.Person;
import com.cadastro.boot.model.User;
import com.cadastro.boot.service.PersonService;
import com.cadastro.boot.service.exception.RecursoNaoEncontradoException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class PersonController {

	@Autowired
	PersonService pessoaService;

	@GetMapping("/pessoas")
	public List<Person> getTodasPessoas() {
		return pessoaService.buscarTodos();
	}

	@GetMapping("/pessoa/{id}")
	public ResponseEntity<Person> getPessoaPorId(@PathVariable(value = "id") Long pessoaId) throws RecursoNaoEncontradoException {
		Person pessoa = pessoaService.buscarPorId(pessoaId);

		checarPessoaNull(pessoaId, pessoa);
		return ResponseEntity.ok().body(pessoa);
	}

	@PostMapping("/pessoa")
	public Person criarPessoa(@Valid @RequestBody Person pessoa) {
		pessoaService.salvar(pessoa);
		return pessoaService.buscarPorId(pessoa.getId());
	}

	@PutMapping("/pessoa/{id}")
	public ResponseEntity<Person> updatePessoa(@PathVariable(value = "id") Long pessoaId, @Valid @RequestBody Person pessoaDetalhes) throws RecursoNaoEncontradoException {
		Person pessoa = pessoaService.buscarPorId(pessoaId);
		checarPessoaNull(pessoaId, pessoa);

		pessoa.setName(pessoaDetalhes.getName());
		pessoa.setGenero(pessoaDetalhes.getGenero());
		pessoa.setEmail(pessoaDetalhes.getEmail());
		pessoa.setDataNascimento(pessoaDetalhes.getDataNascimento());
		pessoa.setNaturalidade(pessoaDetalhes.getNaturalidade());
		pessoa.setNacionalidade(pessoaDetalhes.getNacionalidade());
		pessoa.setCpf(pessoaDetalhes.getCpf());
		final Person pessoaAtualizada = pessoaService.editar(pessoa);
		return ResponseEntity.ok(pessoaAtualizada);
	}

	@DeleteMapping("/pessoa/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long pessoaId) throws RecursoNaoEncontradoException {
		Person pessoa = pessoaService.buscarPorId(pessoaId);
		checarPessoaNull(pessoaId, pessoa);

		pessoaService.excluir(pessoaId);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	private void checarPessoaNull(Long pessoaId, Person pessoa) throws RecursoNaoEncontradoException {
		if (pessoa == null) {
			throw new RecursoNaoEncontradoException("Sem Pessoa com o id: " + pessoaId);
		}
	}
	
	@GetMapping(produces = "application/json")
	@RequestMapping({ "/validateLogin" })
	public User validateLogin() {
		return new User("Usuário autenticado");
	}

}
