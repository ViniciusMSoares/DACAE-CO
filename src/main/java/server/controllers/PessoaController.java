package server.controllers;

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

import server.entities.Pessoa;
import server.entities.DTOs.DeputadoDTO;
import server.entities.DTOs.LoginDTO;
import server.entities.DTOs.PessoaDTO;
import server.entities.DTOs.PessoaSPDTO;
import server.services.PessoaService;

@RestController
@CrossOrigin
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;

	@RequestMapping(value = "/pessoa", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Pessoa> cadastrarPessoa(@RequestBody PessoaDTO pessoa) {
		return new ResponseEntity<>(pessoaService.save(pessoa), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/pessoasp", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Pessoa> cadastrarPessoa(@RequestBody PessoaSPDTO pessoaSP) {
		return new ResponseEntity<>(pessoaService.save(pessoaSP), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/deputado", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Pessoa> cadastrarDeputado(@RequestBody DeputadoDTO deputado) {
		return new ResponseEntity<>(pessoaService.save(deputado), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/pessoa/dni", method = RequestMethod.GET)
	public ResponseEntity<String> exibirPessoa(@RequestParam String dni) { 
		return new ResponseEntity<String>(pessoaService.findByDni(dni).toString(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/pessoa/list", method = RequestMethod.GET)
	public ResponseEntity<List<Pessoa>> getPessoaList() { 
		return new ResponseEntity<List<Pessoa>>(pessoaService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> login(@RequestBody LoginDTO login) {
        return pessoaService.login(login);
	}
	
}
