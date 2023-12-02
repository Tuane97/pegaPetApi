package br.feevale.projeto_pega_pet.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "adotante")
public class Adotante {

    @Id
    private Long adotanteId;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private String endereco;
    private String caracteristicasInteresse;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "adotante")
    private List<Animal> animais = new ArrayList<>();
}
