package br.feevale.projeto_pega_pet.controller.response;

import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ContatoResponse {

    private Long contatoId;

    private Long usuarioId;

    private String nrContato;
}
