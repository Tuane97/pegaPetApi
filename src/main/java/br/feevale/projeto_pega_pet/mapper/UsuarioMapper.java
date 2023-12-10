package br.feevale.projeto_pega_pet.mapper;


import br.feevale.projeto_pega_pet.controller.request.CriarUsuarioRequest;
import br.feevale.projeto_pega_pet.controller.response.ContatoResponse;
import br.feevale.projeto_pega_pet.controller.response.UsuarioResponse;
import br.feevale.projeto_pega_pet.domain.Contato;
import br.feevale.projeto_pega_pet.domain.Usuario;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class UsuarioMapper {
    public static UsuarioResponse toResponse(Usuario usuario) {
        return UsuarioResponse.builder()
                .idUsuario(usuario.getId())
                .nome(usuario.getNome())
                .email(usuario.getEmail())
                .foto(usuario.getFoto())
                .endereco(usuario.getEndereco())
                .tipoUsuario(usuario.getTipoUsuario())
                .contatos(getContatos(usuario.getContatos()))
                .build();
    }

    private static List<ContatoResponse> getContatos(List<Contato> contatos) {
        return contatos.stream().map(ContatoMapper::toResponse).collect(toList());
    }

    public static Usuario toEntity(CriarUsuarioRequest request) {
        return Usuario.builder()
                .ativo(true)
                .tipoUsuario(request.getTipoUsuario())
                .nome(request.getNome())
                .email(request.getEmail())
                .endereco(request.getEndereco())
                .foto(request.getFoto())
                .contatos(new ArrayList<>())
            .build();
    }


}
