package br.feevale.projeto_pega_pet.repository;

import br.feevale.projeto_pega_pet.domain.ProcessoAdocao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessoAdocaoRepository extends JpaRepository<ProcessoAdocao, Long> {

}
