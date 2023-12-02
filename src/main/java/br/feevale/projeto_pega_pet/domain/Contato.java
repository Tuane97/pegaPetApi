package br.feevale.projeto_pega_pet.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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
    private Long contatoId;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private String nrContato;

    @Email
    private String email;

}
