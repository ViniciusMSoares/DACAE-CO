package server.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import server.entities.Deputado;
import server.entities.Pessoa;
import server.entities.DTOs.DeputadoDTO;
import server.entities.DTOs.LoginDTO;
import server.entities.DTOs.PessoaDTO;
import server.entities.DTOs.PessoaSPDTO;
import server.repositories.DeputadoRepository;
import server.repositories.PessoaRepository;
import server.security.TokenAuthenticationService;
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
	@Cacheable(cacheNames = "Pessoa", key="#root.methodName")
	public Flux<Pessoa> findAll() {
		System.out.println(">>>>> Essa operação tem cache <<<<<");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pessoaRepository.findAll();
	}

	@Override
	@CacheEvict(cacheNames = "Pessoa", allEntries = true)
	public Mono<Pessoa> save(PessoaDTO pessoaDTO) {
		Pessoa pessoa = new Pessoa(pessoaDTO.getNome(), pessoaDTO.getDni(), pessoaDTO.getEstado(), pessoaDTO.getInteresses(), pessoaDTO.getSenha(), pessoaDTO.getPartido());
		return pessoaRepository.save(pessoa);
	}
	
	public Mono<Pessoa> save(PessoaSPDTO pessoaSPDTO) {
		Pessoa pessoa = new Pessoa(pessoaSPDTO.getNome(), pessoaSPDTO.getDni(), pessoaSPDTO.getEstado(), pessoaSPDTO.getInteresses(), pessoaSPDTO.getSenha());
		return pessoaRepository.save(pessoa);
	}
	
	@Override
	public Mono<Deputado> save(DeputadoDTO deputadoDTO, String token) {
		Pessoa pessoa = this.findByDni(TokenAuthenticationService.getAuth(token));
		Deputado deputado = new Deputado(pessoa, deputadoDTO.getDataDeInicio());
		pessoaRepository.delete(pessoa);
		return deputadoRepository.save(deputado);
	}

	@Override
	public void delete(Long dni) {
		// TODO Auto-generated method stub

	}

	@Override
	public Flux<Deputado> findAllDeputado() {
		return deputadoRepository.findAll();
	}

	@Override
	public ResponseEntity<String> login(LoginDTO login) {
        Pessoa pessoa = this.findByDni(login.getDni());
        JSONObject body = new JSONObject();
        if (pessoa == null || !pessoa.getSenha().equals(login.getSenha())){
            body.put("token", JSONObject.NULL);
            body.put("message", "Dni ou senha não conferem.");
            body.put("pessoa", JSONObject.NULL);

            return new ResponseEntity<>(body.toString(), HttpStatus.FORBIDDEN);
        }

        body.put("token", TokenAuthenticationService.generateToken(pessoa.getDni()));//falta gerar o token
        body.put("message", "Usuario Autorizado.");

        JSONObject jsonUser = new JSONObject();
        jsonUser.put("dni", pessoa.getDni());
        jsonUser.put("nome", pessoa.getNome());

        body.put("pessoa", jsonUser);
        return new ResponseEntity<>(body.toString(), HttpStatus.ACCEPTED);
	}

}
