package br.feevale.projeto_pega_pet.repository;

import br.feevale.projeto_pega_pet.domain.Animal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

    Page<Animal> findAllByDisponivel(boolean disponivel, Pageable pageable);

    Page<Animal> findAllByOngIdAndDisponivel(Long ongId, boolean disponivel, Pageable pageable);

    Page<Animal> findAllByAdotanteId(Long adotanteId, Pageable pageable);

}
