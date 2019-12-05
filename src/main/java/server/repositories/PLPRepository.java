package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import server.entities.PLP;

public interface PLPRepository extends ReactiveCrudRepository<PLP, Long> {

}