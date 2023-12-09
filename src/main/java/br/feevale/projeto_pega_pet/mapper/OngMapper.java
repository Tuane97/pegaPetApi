package br.feevale.projeto_pega_pet.mapper;

import br.feevale.projeto_pega_pet.controller.response.AdotanteEOngResponse;
import br.feevale.projeto_pega_pet.domain.Ong;
import br.feevale.projeto_pega_pet.domain.Usuario;

public class OngMapper {
    public static Ong toFirstEntity(Usuario usuarioSalvo, String cnpj) {
        return Ong.builder()
                .usuario(usuarioSalvo)
                .cnpj(cnpj)
                .build();
    }

    public static AdotanteEOngResponse toResponse(Ong ong) {
        return AdotanteEOngResponse.builder()
                .id(ong.getId())
                .nome(ong.getUsuario().getNome())
                .build();
    }
}
