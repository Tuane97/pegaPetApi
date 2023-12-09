package br.feevale.projeto_pega_pet.mapper;

import br.feevale.projeto_pega_pet.controller.response.AdotanteEOngResponse;
import br.feevale.projeto_pega_pet.domain.Adotante;
import br.feevale.projeto_pega_pet.domain.Usuario;

public class AdotanteMapper {
    public static Adotante toFirstEntity(Usuario usuarioSalvo, String caracteristicas) {
        return Adotante.builder()
                .usuario(usuarioSalvo)
                .caracteristicasInteresse(caracteristicas)
                .build();
    }

    public static AdotanteEOngResponse toResponse(Adotante adotante) {
        return AdotanteEOngResponse.builder()
                .id(adotante.getId())
                .nome(adotante.getUsuario().getNome())
                .build();
    }
}
