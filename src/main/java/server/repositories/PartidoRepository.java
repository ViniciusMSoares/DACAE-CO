package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import server.entities.Partido;

public interface PartidoRepository extends JpaRepository<Partido, Long> {

}
