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
    private Long ongId;

    @CNPJ
    private String cnpj;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToMany
    @JoinColumn(name = "animais")
    private List<Animal> animais = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "processos_adocao")
    private List<ProcessoAdocao> processosAdocao = new ArrayList<>();
}