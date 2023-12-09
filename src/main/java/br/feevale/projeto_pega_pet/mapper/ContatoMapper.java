package br.feevale.projeto_pega_pet.mapper;

import br.feevale.projeto_pega_pet.controller.response.ContatoResponse;
import br.feevale.projeto_pega_pet.domain.Contato;
import br.feevale.projeto_pega_pet.domain.Usuario;

public class ContatoMapper {
    public static Contato toEntity(String nrContato, Usuario usuario) {
        return Contato.builder()
                .usuario(usuario)
                .nrContato(nrContato)
                .build();
    }

    public static ContatoResponse toResponse(Contato contato) {
        return ContatoResponse.builder()
                .contatoId(contato.getId())
                .usuarioId(contato.getUsuario().getId())
                .nrContato(contato.getNrContato())
                .build();
    }
}
