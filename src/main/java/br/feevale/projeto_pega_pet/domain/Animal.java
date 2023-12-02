package br.feevale.projeto_pega_pet.domain;

import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "animal")
public class Animal {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long animalId;

    private String foto;
    private String nome;
    private String idade;
    private String raca;
    private String caracteristicas;
    private boolean disponivel;

    @ManyToOne
    @JoinColumn(name = "ong_id")
    private Ong ong;

    @ManyToOne
    @JoinColumn(name = "adotante_id")
    private Adotante adotante;

}