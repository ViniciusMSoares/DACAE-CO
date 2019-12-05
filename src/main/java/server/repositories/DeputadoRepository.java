package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import server.entities.Deputado;

public interface DeputadoRepository extends ReactiveCrudRepository<Deputado, Long> {

}