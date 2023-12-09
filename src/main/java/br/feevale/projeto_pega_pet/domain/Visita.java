package br.feevale.projeto_pega_pet.domain;

import br.feevale.projeto_pega_pet.domain.enums.StatusVisita;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "visita")
public class Visita {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Enumerated(STRING)
    private StatusVisita status;
    private LocalDate data;
    private LocalTime hora;
    private int cdStatus;
    private String observacao;
}