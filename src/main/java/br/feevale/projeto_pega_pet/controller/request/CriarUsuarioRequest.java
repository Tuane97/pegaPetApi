package br.feevale.projeto_pega_pet.controller.request;

import br.feevale.projeto_pega_pet.domain.enums.TipoUsuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.hibernate.validator.constraints.br.CNPJ;

@Getter
public class CriarUsuarioRequest {

    @NotNull
    private TipoUsuario tipoUsuario;

    @NotNull
    private String Nome;

    @Email
    @NotNull
    private String email;

    private String endereco;

    @NotNull
    private String Senha;

    @CNPJ
    private String cnpj;

    @NotNull
    private String nrContato;

    private String foto;

    private String caracteristicasInteresse;

}
