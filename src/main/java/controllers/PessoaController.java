package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import entities.Pessoa;
import entities.DTOs.PessoaDTO;
import services.PessoaService;

@RestController
@CrossOrigin
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;

	@RequestMapping(value = "/pessoa", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Pessoa> cadastrarPessoa(@RequestBody PessoaDTO pessoa) {
		return new ResponseEntity<>(pessoaService.save(pessoa), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/pessoa/dni", method = RequestMethod.GET)
	public ResponseEntity<List<Pessoa>> getPessoaByDni() { 
		return new ResponseEntity<List<Pessoa>>(pessoaService.findAll(), HttpStatus.OK);
	}
	
}
