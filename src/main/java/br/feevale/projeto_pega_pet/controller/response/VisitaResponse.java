package br.feevale.projeto_pega_pet.controller.response;

import br.feevale.projeto_pega_pet.domain.enums.StatusVisita;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VisitaResponse {

    private Long id;
    private String animal;
    private StatusVisita status;
    private LocalDate data;
    private LocalTime hora;
    private String observacao;
    private String Ong;
    private String Adotante;
}
