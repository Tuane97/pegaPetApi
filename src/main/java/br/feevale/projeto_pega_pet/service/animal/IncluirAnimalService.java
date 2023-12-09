package br.feevale.projeto_pega_pet.service.animal;

import br.feevale.projeto_pega_pet.controller.request.AnimalRequest;
import br.feevale.projeto_pega_pet.domain.Animal;
import br.feevale.projeto_pega_pet.domain.Ong;
import br.feevale.projeto_pega_pet.mapper.AnimalMapper;
import br.feevale.projeto_pega_pet.repository.AnimalRepository;
import br.feevale.projeto_pega_pet.repository.OngRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IncluirAnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private OngRepository ongRepository;

    @Transactional
    public void criar(AnimalRequest request) {

        Ong ong = ongRepository.findById(request.getOngId()).get();
        Animal animal = AnimalMapper.toEntity(request);
        animal.setDisponivel(true);
        animal.setOng(ong);
        animalRepository.save(animal);

    }

}
