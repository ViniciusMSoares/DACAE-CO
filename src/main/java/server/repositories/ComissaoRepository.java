package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import server.entities.Comissao;

public interface ComissaoRepository extends ReactiveCrudRepository<Comissao, Long> {

}
