package br.feevale.projeto_pega_pet.repository;

import br.feevale.projeto_pega_pet.domain.Ong;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OngRepository extends JpaRepository<Ong, Long> {

}
