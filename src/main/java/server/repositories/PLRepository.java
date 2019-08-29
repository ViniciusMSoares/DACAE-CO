package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import server.entities.PL;

public interface PLRepository extends JpaRepository<PL, Long> {

}
