package br.feevale.projeto_pega_pet.mapper;

import br.feevale.projeto_pega_pet.controller.request.AnimalRequest;
import br.feevale.projeto_pega_pet.controller.response.AnimalResponse;
import br.feevale.projeto_pega_pet.domain.Animal;

import static java.util.Objects.nonNull;

public class AnimalMapper {
    public static AnimalResponse toResponse(Animal animal) {

        return AnimalResponse.builder()
                .id(animal.getId())
                .nome(animal.getNome())
                .idade(animal.getIdade())
                .raca(animal.getRaca())
                .foto(animal.getFoto())
                .ong(OngMapper.toResponse(animal.getOng()))
                .adotante(nonNull(animal.getAdotante()) ? AdotanteMapper.toResponse(animal.getAdotante()) : null)
                .caracteristicas(animal.getCaracteristicas())
                .build();
    }

    public static Animal toEntity(AnimalRequest request) {
        return Animal.builder()
                .idade(request.getIdade())
                .nome(request.getNome())
                .raca(request.getRaca())
                .foto(request.getFoto())
                .caracteristicas(request.getCaracteristicas())
                .build();
    }
}
