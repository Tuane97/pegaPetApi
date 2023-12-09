package br.feevale.projeto_pega_pet.service.animal;

import br.feevale.projeto_pega_pet.controller.response.AnimalResponse;
import br.feevale.projeto_pega_pet.domain.Animal;
import br.feevale.projeto_pega_pet.mapper.AnimalMapper;
import br.feevale.projeto_pega_pet.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@Service
public class BuscarAnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    public AnimalResponse buscar(Long idAnimal) {
        Animal animal= animalRepository.findById( idAnimal)
                .orElseThrow(() -> new ResponseStatusException(UNPROCESSABLE_ENTITY, "Animal não encontrado"));;
        return AnimalMapper.toResponse(animal);
    }
}
