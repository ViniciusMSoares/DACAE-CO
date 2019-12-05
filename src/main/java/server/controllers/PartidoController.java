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
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;
import server.entities.Partido;
import server.entities.Pessoa;
import server.entities.DTOs.PartidoDTO;
import server.services.PartidoService;

@RestController
@CrossOrigin
public class PartidoController {

	@Autowired
	private PartidoService partidoService;
	
	@RequestMapping(value = "/partido", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Mono<Partido>> cadastrarPartido(@RequestBody PartidoDTO partido) {
		return new ResponseEntity<>(partidoService.save(partido), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/partido/base", method = RequestMethod.GET)
	public ResponseEntity<String> exibirBase() { 
		return new ResponseEntity<String>(partidoService.baseGovernista(), HttpStatus.OK);
	}
	
}
