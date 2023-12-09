package br.feevale.projeto_pega_pet.controller.response;

import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AnimalResponse {

    private Long id;
    private String nome;
    private String idade;
    private AdotanteEOngResponse ong;
    private AdotanteEOngResponse adotante;
    private String raca;
    private String caracteristicas;

}
