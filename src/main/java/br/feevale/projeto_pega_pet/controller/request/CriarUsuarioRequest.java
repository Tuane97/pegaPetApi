package br.feevale.projeto_pega_pet.controller.request;

import br.feevale.projeto_pega_pet.domain.enums.TipoUsuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

@Getter
@Setter
public class CriarUsuarioRequest {

    @NotNull
    private TipoUsuario tipoUsuario;

    @NotNull
    private String Nome;

    @Email
    @NotNull
    private String email;

    @NotNull
    private String Senha;

    @CNPJ
    private String cnpj;

    @NotNull
    private String nrContato;

    private boolean ativo;

    private String foto;

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNrContato() {
        return nrContato;
    }

    public void setNrContato(String nrContato) {
        this.nrContato = nrContato;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
