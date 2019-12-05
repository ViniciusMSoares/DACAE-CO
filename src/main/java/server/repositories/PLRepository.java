package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import server.entities.PL;

public interface PLRepository extends ReactiveCrudRepository<PL, Long> {

}
