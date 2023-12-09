package br.feevale.projeto_pega_pet.repository;

import br.feevale.projeto_pega_pet.domain.Adotante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdotanteRepository extends JpaRepository<Adotante, Long> {
    Optional<Adotante> findByUsuarioId(Long idUsuario);
}
