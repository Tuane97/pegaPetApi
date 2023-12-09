package br.feevale.projeto_pega_pet.controller.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProcessoAdocaoRequest {

    private Long ongId;
    private Long adotanteId;
    private Long animalId;
    private String contato;
    private String data;
    private String hora;
    private String detalhe;


}
