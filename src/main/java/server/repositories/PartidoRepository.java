package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import server.entities.Partido;

public interface PartidoRepository extends ReactiveCrudRepository<Partido, Long> {

}
