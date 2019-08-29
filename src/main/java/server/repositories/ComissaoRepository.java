package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import server.entities.Comissao;

public interface ComissaoRepository extends JpaRepository<Comissao, Long> {

}
