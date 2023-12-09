package br.feevale.projeto_pega_pet.controller.response;

import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AdotanteEOngResponse {

    private Long id;
    private String nome;
}
