package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import server.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
