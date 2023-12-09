package br.feevale.projeto_pega_pet.domain;

import br.feevale.projeto_pega_pet.domain.enums.TipoUsuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Enumerated(STRING)
    private TipoUsuario tipoUsuario;

    @Email
    private String email;

    private String endereco;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "usuario")
    private List<Contato> contatos = new ArrayList<>();

    private String nome;

    private String senha;

    private boolean ativo;

    private String foto;

}
