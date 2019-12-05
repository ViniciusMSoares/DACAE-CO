package server.services.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import server.entities.Partido;
import server.entities.DTOs.PartidoDTO;
import server.repositories.PartidoRepository;
import server.services.PartidoService;

@Service
public class PartidoServiceImpl implements PartidoService {
	
	@Autowired
	private PartidoRepository partidoRepository;

	public PartidoServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Mono<Partido> findByNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flux<Partido> findAll() {
		return partidoRepository.findAll();
	}

	@Override
	public Mono<Partido> save(PartidoDTO partidoDTO) {
		Partido partido = new Partido(partidoDTO.getPartido());
		return partidoRepository.save(partido);
	}

	@Override
	public void delete(String partido) {
		// TODO Auto-generated method stub

	}

	@Override
	public String baseGovernista() {
		List<Partido> partidos = (List<Partido>) partidoRepository.findAll();
		Collections.sort(partidos);
		String base = "";
		
		for (int i = 0; i < partidos.size(); i++) {
			base += partidos.get(i).getPartido();
			if (i < partidos.size()-1) {
				base += ",";
			}
		}
		
		return base;
	}

}
