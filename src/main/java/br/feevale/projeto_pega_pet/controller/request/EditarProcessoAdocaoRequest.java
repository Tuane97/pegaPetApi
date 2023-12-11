package br.feevale.projeto_pega_pet.controller.request;

import br.feevale.projeto_pega_pet.domain.enums.StatusProcessoAdocao;
import lombok.Getter;

@Getter
public class EditarProcessoAdocaoRequest {
    private StatusProcessoAdocao status;
    private String observacao;
}
