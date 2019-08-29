package server.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import server.entities.Comissao;
import server.entities.DTOs.ComissaoDTO;
import server.repositories.ComissaoRepository;
import server.services.ComissaoService;

@Service
public class ComissaoServiceImpl implements ComissaoService {
	
	@Autowired
	private ComissaoRepository comissaoRepository;

	@Override
	public Comissao findByNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comissao> findAll() {
		return comissaoRepository.findAll();
	}

	@Override
	public Comissao save(ComissaoDTO comissaoDTO) {
		Comissao comissao = new Comissao(comissaoDTO.getTema(), comissaoDTO.getPoliticos());
		return comissaoRepository.save(comissao);
	}

	@Override
	public void delete(String nome) {
		// TODO Auto-generated method stub
		
	}

	

}
