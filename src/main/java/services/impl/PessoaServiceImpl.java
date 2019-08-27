package services.impl;

import java.util.List;

import entities.Pessoa;
import entities.DTOs.PessoaDTO;
import repositories.PessoaRepository;
import services.PessoaService;

public class PessoaServiceImpl implements PessoaService {
	
	private PessoaRepository pessoaRepository;

	@Override
	public Pessoa findByDni(String dni) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pessoa> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pessoa save(PessoaDTO pessoaDTO) {
		Pessoa pessoa = new Pessoa(pessoaDTO.getNome(), pessoaDTO.getDni(), pessoaDTO.getEstado(), pessoaDTO.getInteresses(), pessoaDTO.getPartido());
		
		return pessoaRepository.save(pessoa);
	}

	@Override
	public void delete(Long dni) {
		// TODO Auto-generated method stub

	}

}
