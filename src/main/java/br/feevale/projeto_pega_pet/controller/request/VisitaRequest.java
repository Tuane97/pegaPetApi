package br.feevale.projeto_pega_pet.controller.request;

import br.feevale.projeto_pega_pet.domain.enums.StatusVisita;
import lombok.Getter;

@Getter
public class VisitaRequest {
    private StatusVisita status;
    private String observacao;
}
