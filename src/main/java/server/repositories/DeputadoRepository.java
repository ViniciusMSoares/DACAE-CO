package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import server.entities.Deputado;

public interface DeputadoRepository extends JpaRepository<Deputado, Long> {

}