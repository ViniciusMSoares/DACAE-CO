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
import org.springframework.web.bind.annotation.RequestParam;

import server.entities.Proposta;
import server.entities.DTOs.PECDTO;
import server.entities.DTOs.PLDTO;
import server.entities.DTOs.PLPDTO;
import server.services.PropostaService;

@Controller
public class PropostaController {

	@Autowired
	private PropostaService propostaService;
	
	public PropostaController() {}
	
	/*
	String cadastrarPL(String dni, int ano, String ementa, String interesses, String url, boolean conclusivo)
	String cadastrarPLP(String dni, int ano, String ementa, String interesses, String url, String artigos)
	String cadastrarPEC(String dni, int ano, String ementa, String interesses, String url, String artigos)
	String exibirProjeto(String codigo)
	 */
	
	@RequestMapping(value = "/proposta/pl", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Proposta> cadastrarPL(@RequestBody PLDTO proposta) {
		return new ResponseEntity<>(propostaService.save(proposta), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/proposta/plp", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Proposta> cadastrarPLP(@RequestBody PLPDTO proposta) {
		return new ResponseEntity<>(propostaService.save(proposta), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/proposta/pec", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Proposta> cadastrarPEC(@RequestBody PECDTO proposta) {
		return new ResponseEntity<>(propostaService.save(proposta), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/proposta/list", method = RequestMethod.GET)
	public ResponseEntity<List<Proposta>> getPropostaList() { 
		return new ResponseEntity<List<Proposta>>(propostaService.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/proposta/codigo", method = RequestMethod.GET)
	public ResponseEntity<String> exibirProjeto(@RequestParam String codigo) { 
		return new ResponseEntity<String>(propostaService.findByCodigo(codigo).toString(), HttpStatus.OK);
	}
	
}







