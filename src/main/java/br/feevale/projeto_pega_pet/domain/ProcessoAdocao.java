package br.feevale.projeto_pega_pet.domain;

import br.feevale.projeto_pega_pet.domain.enums.StatusProcessoAdocao;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "processo_adocao")
public class ProcessoAdocao {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ong_id")
    private Ong ong;

    @ManyToOne
    @JoinColumn(name = "adotante_id")
    private Adotante adotante;

    @ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;

    @Enumerated(STRING)
    private StatusProcessoAdocao status;

    private int cdStatus;

    private LocalDate dataInicio;
    private String detalhe;

    @ManyToOne
    @JoinColumn(name = "visita_id")
    private Visita visita;
}