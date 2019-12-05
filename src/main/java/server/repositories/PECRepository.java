package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import server.entities.PEC;

public interface PECRepository extends ReactiveCrudRepository<PEC, Long> {

}