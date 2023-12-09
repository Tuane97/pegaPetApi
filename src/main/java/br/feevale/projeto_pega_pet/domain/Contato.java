package br.feevale.projeto_pega_pet.domain;

import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "contato")
public class Contato {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private String nrContato;

}
