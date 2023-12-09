package br.feevale.projeto_pega_pet.repository;

import br.feevale.projeto_pega_pet.domain.Ong;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OngRepository extends JpaRepository<Ong, Long> {

    Optional<Ong> findByUsuarioId(Long idUsuario);
}
