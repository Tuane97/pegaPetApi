package br.feevale.projeto_pega_pet.repository;

import br.feevale.projeto_pega_pet.domain.ProcessoAdocao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProcessoAdocaoRepository extends JpaRepository<ProcessoAdocao, Long> {

    Page<ProcessoAdocao> findAllByOngIdOrderByCdStatus(Long id, Pageable pageable);

    Page<ProcessoAdocao> findAllByAdotanteIdOrderByCdStatus(Long adotanteId, Pageable pageable);

    Optional<ProcessoAdocao> findByVisitaId(Long id);
}
