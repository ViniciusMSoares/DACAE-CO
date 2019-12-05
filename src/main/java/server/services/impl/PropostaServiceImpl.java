package server.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import server.entities.Deputado;
import server.entities.PEC;
import server.entities.PL;
import server.entities.PLP;
import server.entities.Pessoa;
import server.entities.Proposta;
import server.entities.Votacao;
import server.entities.DTOs.PECDTO;
import server.entities.DTOs.PLDTO;
import server.entities.DTOs.PLPDTO;
import server.entities.DTOs.VotacaoDTO;
import server.repositories.DeputadoRepository;
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
	
	@Autowired
	private DeputadoRepository deputadoRepository;
	
	public PropostaServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Proposta findByCodigo(String codigo) {
		Flux<Proposta> propostas = propostaRepository.findAll();
		for (Proposta proposta : (List<Proposta>) propostas) {
			if (proposta.getCodigo().equals(codigo)) {
				return proposta;
			}
		}

		return null;
	}

	@Override
	public Flux<Proposta> findAll() {
		return propostaRepository.findAll();
	}

	@Override
	public Mono<PL> save(PLDTO proposta) {
		PL pl = new PL(proposta.getAutor(), proposta.getAno(), proposta.getEmenta(), proposta.getInteresses(), proposta.getEnderecoDoc(), proposta.isConclusivo());
		this.atualizaLeisAutor(proposta.getAutor());
		return plRepository.save(pl);
	}

	@Override
	public Mono<PLP> save(PLPDTO proposta) {
		PLP plp = new PLP(proposta.getAutor(), proposta.getAno(), proposta.getEmenta(), proposta.getInteresses(), proposta.getEnderecoDoc(), proposta.getArtigo());
		this.atualizaLeisAutor(proposta.getAutor());
		return plpRepository.save(plp);
	}

	@Override
	public Mono<PEC> save(PECDTO proposta) {
		PEC pec = new PEC(proposta.getAutor(), proposta.getAno(), proposta.getEmenta(), proposta.getInteresses(), proposta.getEnderecoDoc(), proposta.getArtigo());
		this.atualizaLeisAutor(proposta.getAutor());
		return pecRepository.save(pec);
	}

	@Override
	public void delete(String partido) {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean votar(VotacaoDTO votacaoDTO) {
		Flux<Deputado> deputados = pessoaService.findAllDeputado();
		String base = "ABC";//partidoService.baseGovernista();
		Proposta proposta = propostaService.findByCodigo(votacaoDTO.getCodigo());
		int votos = 0;
		for (Deputado deputado : (List<Deputado>) deputados) {
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
		
		return votos > (((List<Proposta>) deputados).size()/2);
	}
	
	
	private void atualizaLeisAutor(String dni) {
		 Deputado autor = (Deputado) pessoaService.findByDni(dni);
		 autor.setNumLeis(autor.getNumLeis()+1);
		 deputadoRepository.save(autor);
	}
	

}
