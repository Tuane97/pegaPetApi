package br.feevale.projeto_pega_pet.repository;

import br.feevale.projeto_pega_pet.domain.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<Contato, Long> {

}
