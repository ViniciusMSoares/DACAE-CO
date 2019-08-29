package server.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import server.entities.Deputado;
import server.entities.PEC;
import server.entities.PL;
import server.entities.PLP;
import server.entities.Proposta;
import server.entities.Votacao;
import server.entities.DTOs.PECDTO;
import server.entities.DTOs.PLDTO;
import server.entities.DTOs.PLPDTO;
import server.entities.DTOs.VotacaoDTO;
import server.repositories.PECRepository;
import server.repositories.PLPRepository;
import server.repositories.PLRepository;
import server.repositories.PropostaRepository;
import server.services.PartidoService;
import server.services.PessoaService;
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
	
	@Autowired
	private PessoaService pessoaService;
	
	@Autowired
	private PartidoService partidoService;
	
	@Autowired
	private PropostaService propostaService;
	
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
	public boolean votar(VotacaoDTO votacaoDTO) {
		List<Deputado> deputados = pessoaService.findAllDeputado();
		String base = partidoService.baseGovernista();
		Proposta proposta = propostaService.findByCodigo(votacaoDTO.getCodigo());
		int votos = 0;
		for (Deputado deputado : deputados) {
			if (votacaoDTO.getStatusGovernista().equals("GOVERNISTA")) {
				if (base.contains(deputado.getPartido())) {
					votos++;
				}
			}
			else if (votacaoDTO.getStatusGovernista().equals("OPOSICAO")) {
				if (!base.contains(deputado.getPartido())) {
					votos++;
				}
			}
			else {
				boolean aprova = false;
				for (String interesse : deputado.getInteresses().split(",")) {
					if (proposta.getInteresses().contains(interesse)) {
						aprova = true;
					}
				}
				if (aprova) {
					votos++;
				}
			}
		}
		
		return votos > (deputados.size()/2);
	}
	
	

}
