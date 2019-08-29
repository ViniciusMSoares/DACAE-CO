package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import server.entities.PEC;

public interface PECRepository extends JpaRepository<PEC, Long> {

}