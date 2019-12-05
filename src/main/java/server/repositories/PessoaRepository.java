package server.repositories;

import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import server.entities.Pessoa;

public interface PessoaRepository extends ReactiveCrudRepository<Pessoa, Long> {

	Optional<Pessoa> findOne(Example<Pessoa> of);

}
