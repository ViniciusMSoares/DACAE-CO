package server.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import server.entities.Deputado;
import server.entities.Pessoa;
import server.entities.DTOs.DeputadoDTO;
import server.entities.DTOs.PessoaDTO;
import server.entities.DTOs.PessoaSPDTO;
import server.repositories.DeputadoRepository;
import server.repositories.PessoaRepository;
import server.services.PessoaService;

@Service
public class PessoaServiceImpl implements PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private DeputadoRepository deputadoRepository;
	
	@Override
	public Pessoa findByDni(String dni) {
		Pessoa pessoa = new Pessoa();
		pessoa.setDni(dni);
		//olhar optional
		Optional<Pessoa> result = pessoaRepository.findOne(Example.of(pessoa));
		
		return result.get();
	}

	@Override
	public List<Pessoa> findAll() {
		return pessoaRepository.findAll();
	}

	@Override
	public Pessoa save(PessoaDTO pessoaDTO) {
		Pessoa pessoa = new Pessoa(pessoaDTO.getNome(), pessoaDTO.getDni(), pessoaDTO.getEstado(), pessoaDTO.getInteresses(), pessoaDTO.getPartido());
		return pessoaRepository.save(pessoa);
	}
	
	@Override
	public Pessoa save(PessoaSPDTO pessoaSPDTO) {
		Pessoa pessoa = new Pessoa(pessoaSPDTO.getNome(), pessoaSPDTO.getDni(), pessoaSPDTO.getEstado(), pessoaSPDTO.getInteresses());
		return pessoaRepository.save(pessoa);
	}
	
	@Override
	public Deputado save(DeputadoDTO deputadoDTO) {
		Pessoa pessoa = this.findByDni(deputadoDTO.getDni());
		Deputado deputado = new Deputado(pessoa, deputadoDTO.getDataDeInicio());
		pessoaRepository.delete(pessoa);
		return deputadoRepository.save(deputado);
	}

	@Override
	public void delete(Long dni) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Deputado> findAllDeputado() {
		return deputadoRepository.findAll();
	}

}
