package br.feevale.projeto_pega_pet.domain;

import br.feevale.projeto_pega_pet.domain.enums.TipoUsuario;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long usuarioId;

    @Enumerated(STRING)
    private TipoUsuario tipoUsuario;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "usuario")
    private List<Contato> contatos = new ArrayList<>();

    private String nome;

    private String senha;

    private boolean ativo;

    private String foto;

    public Long getUsuarioId() {
        return usuarioId;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public String getFoto() {
        return foto;
    }
}
