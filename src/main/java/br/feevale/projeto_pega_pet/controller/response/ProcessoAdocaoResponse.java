package br.feevale.projeto_pega_pet.controller.response;

import br.feevale.projeto_pega_pet.domain.enums.StatusProcessoAdocao;
import lombok.*;

import java.time.LocalDate;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProcessoAdocaoResponse {

    private Long id;
    private AdotanteEOngResponse adotante;
    private AdotanteEOngResponse ong;
    private AnimalResponse animal;
    private StatusProcessoAdocao status;
    private LocalDate dataInicio;
    private String detalhes;
    private VisitaResponse visita;

}
