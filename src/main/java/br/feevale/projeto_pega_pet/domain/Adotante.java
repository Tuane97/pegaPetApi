package br.feevale.projeto_pega_pet.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "adotante")
public class Adotante {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private String caracteristicasInteresse;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "adotante")
    private List<Animal> animais = new ArrayList<>();
}
