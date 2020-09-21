package com.cadastro.boot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/source/v1")
public class SourceController {
	
	@GetMapping("/url")
	public Map<String, String> getTodasPessoas() {
		Map<String, String> retorno = new HashMap<>();
		retorno.put("client angular", "endpoint REST com spring boot");
		return retorno;
	}

}
