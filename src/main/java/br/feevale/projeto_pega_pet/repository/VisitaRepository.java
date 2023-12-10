package br.feevale.projeto_pega_pet.repository;

import br.feevale.projeto_pega_pet.domain.Visita;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VisitaRepository extends JpaRepository<Visita, Long> {

    @Query(value = "SELECT VST.* FROM VISITA VST JOIN PROCESSO_ADOCAO PA ON VST.ID = PA.VISITA_ID WHERE PA.ONG_ID = ?1",
            nativeQuery = true)
    Page<Visita> findByOng(Long usuarioId, Pageable pageable);

    @Query(value = "SELECT VST.* FROM VISITA VST JOIN PROCESSO_ADOCAO PA ON VST.ID = PA.VISITA_ID WHERE PA.ADOTANTE_ID = ?1",
            nativeQuery = true)
    Page<Visita> findByAdotante(Long usuarioId, Pageable pageable);
}
