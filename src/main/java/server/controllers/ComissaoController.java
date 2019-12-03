package server.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import server.clients.Client;
import server.entities.Comissao;
import server.entities.DTOs.ComissaoDTO;
import server.services.ComissaoService;

@Controller
public class ComissaoController {

	@Autowired
	private ComissaoService comissaoService;
	
	private Client client;

	@RequestMapping(value = "/comissao", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Comissao> cadastrarPessoa(@RequestBody ComissaoDTO comissao) {
		return new ResponseEntity<>(comissaoService.save(comissao), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/comissao", method = RequestMethod.GET)
	public ResponseEntity<List<Comissao>> getComissaoList() { 
		return new ResponseEntity<List<Comissao>>(comissaoService.findAll(), HttpStatus.OK);
	}
	
}
