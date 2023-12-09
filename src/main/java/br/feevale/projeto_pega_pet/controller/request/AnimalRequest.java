package br.feevale.projeto_pega_pet.controller.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AnimalRequest {

    private Long ongId;
    private String nome;
    private String idade;
    private String raca;
    private String foto;
    private boolean adotado;
    private String caracteristicas;
}
