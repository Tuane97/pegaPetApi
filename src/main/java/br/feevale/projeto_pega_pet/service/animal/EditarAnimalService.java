package br.feevale.projeto_pega_pet.service.animal;

import br.feevale.projeto_pega_pet.controller.request.AnimalRequest;
import br.feevale.projeto_pega_pet.domain.Animal;
import br.feevale.projeto_pega_pet.domain.Ong;
import br.feevale.projeto_pega_pet.mapper.AnimalMapper;
import br.feevale.projeto_pega_pet.repository.AnimalRepository;
import br.feevale.projeto_pega_pet.repository.OngRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditarAnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private OngRepository ongRepository;

    public void editar(AnimalRequest request, Long idAnimal) {
        Animal animal = AnimalMapper.toEntity(request);
        animal.setId(idAnimal);
        animal.setDisponivel(!request.isAdotado());
        Ong ong = ongRepository.findById(request.getOngId()).get();
        animal.setOng(ong);
        animalRepository.save(animal);
    }
}
