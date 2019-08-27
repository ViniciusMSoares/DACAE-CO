package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
