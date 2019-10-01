package server.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import server.entities.Proposta;
import server.entities.DTOs.PECDTO;
import server.entities.DTOs.PLDTO;
import server.entities.DTOs.PLPDTO;
import server.entities.DTOs.VotacaoDTO;
import server.services.PropostaService;

@Controller
public class PropostaController {

	@Autowired
	private PropostaService propostaService;
	
	public PropostaController() {}
	
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
	
	@RequestMapping(value = "/proposta", method = RequestMethod.GET)
	public ResponseEntity<List<Proposta>> getPropostaList() { 
		return new ResponseEntity<List<Proposta>>(propostaService.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/proposta/{codigo}", method = RequestMethod.GET)
	public ResponseEntity<String> exibirProjeto(@PathVariable("codigo") String codigo) { 
		return new ResponseEntity<String>(propostaService.findByCodigo(codigo).toString(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/proposta/votar", method = RequestMethod.GET)
	public ResponseEntity<Boolean> votarComissao(@RequestBody VotacaoDTO votacao) {
		return new ResponseEntity<>(propostaService.votar(votacao), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/tramitacao/{codigo}", method = RequestMethod.GET)
	public ResponseEntity<String> exibirTramitacao(@PathVariable("codigo") String codigo) {
		return new ResponseEntity<String>(/*propostaService.findByCodigo(codigo).toString(), */HttpStatus.OK);
	}
	
}







