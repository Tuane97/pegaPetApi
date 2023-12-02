package br.feevale.projeto_pega_pet.repository;

import br.feevale.projeto_pega_pet.domain.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

}
