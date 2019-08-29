package server.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import server.entities.PEC;
import server.entities.PL;
import server.entities.PLP;
import server.entities.Proposta;
import server.entities.DTOs.PECDTO;
import server.entities.DTOs.PLDTO;
import server.entities.DTOs.PLPDTO;
import server.entities.DTOs.VotacaoDTO;
import server.repositories.PECRepository;
import server.repositories.PLPRepository;
import server.repositories.PLRepository;
import server.repositories.PropostaRepository;
import server.services.PropostaService;

@Service
public class PropostaServiceImpl implements PropostaService {

	@Autowired
	private PropostaRepository propostaRepository;
	
	@Autowired
	private PLRepository plRepository;
	
	@Autowired
	private PLPRepository plpRepository;
	
	@Autowired
	private PECRepository pecRepository;
	
	public PropostaServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Proposta findByCodigo(String codigo) {
		List<Proposta> propostas = propostaRepository.findAll();
		for (Proposta proposta : propostas) {
			if (proposta.getCodigo().equals(codigo)) {
				return proposta;
			}
		}

		return null;
	}

	@Override
	public List<Proposta> findAll() {
		return propostaRepository.findAll();
	}

	@Override
	public PL save(PLDTO proposta) {
		PL pl = new PL(proposta.getAutor(), proposta.getAno(), proposta.getEmenta(), proposta.getInteresses(), proposta.getEnderecoDoc(), proposta.isConclusivo());
		return plRepository.save(pl);
	}

	@Override
	public PLP save(PLPDTO proposta) {
		PLP plp = new PLP(proposta.getAutor(), proposta.getAno(), proposta.getEmenta(), proposta.getInteresses(), proposta.getEnderecoDoc(), proposta.getArtigo());
		return plpRepository.save(plp);
	}

	@Override
	public PEC save(PECDTO proposta) {
		PEC pec = new PEC(proposta.getAutor(), proposta.getAno(), proposta.getEmenta(), proposta.getInteresses(), proposta.getEnderecoDoc(), proposta.getArtigo());
		return pecRepository.save(pec);
	}

	@Override
	public void delete(String partido) {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean votar(VotacaoDTO votacao) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
