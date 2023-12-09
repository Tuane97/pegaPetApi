package br.feevale.projeto_pega_pet.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.br.CNPJ;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ong")
public class Ong {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @CNPJ
    private String cnpj;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "ong")
    private List<Animal> animais = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "ong")
    private List<ProcessoAdocao> processosAdocao = new ArrayList<>();
}