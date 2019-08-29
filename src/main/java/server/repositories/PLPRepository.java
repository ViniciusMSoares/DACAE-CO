package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import server.entities.PLP;

public interface PLPRepository extends JpaRepository<PLP, Long> {

}