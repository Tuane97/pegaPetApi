package br.feevale.projeto_pega_pet.service.animal;

import br.feevale.projeto_pega_pet.controller.response.AnimalResponse;
import br.feevale.projeto_pega_pet.domain.Animal;
import br.feevale.projeto_pega_pet.mapper.AnimalMapper;
import br.feevale.projeto_pega_pet.repository.AdotanteRepository;
import br.feevale.projeto_pega_pet.repository.AnimalRepository;
import br.feevale.projeto_pega_pet.repository.OngRepository;
import br.feevale.projeto_pega_pet.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ListarAnimaisService {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AdotanteRepository adotanteRepository;

    @Autowired
    private OngRepository ongRepository;

    public Page<AnimalResponse> listarDisp(Pageable pageable) {
        Page<Animal> animais = animalRepository.findAllByDisponivel(true, pageable);


        System.out.println(animais.toString());
        return animais.map(animal -> {
            AnimalResponse response = AnimalMapper.toResponse(animal);
            return response;
        });
    }

    public Page<AnimalResponse> listarPorOng(Long ongId, Pageable pageable) {
        Page<Animal> animais = animalRepository.findAllByOngIdAndDisponivel(ongId, true, pageable);
        return animais.map(AnimalMapper::toResponse);
    }

    public Page<AnimalResponse> listarPorAdotante(Long idAdotante, Pageable pageable) {
        Page<Animal> animais = animalRepository.findAllByAdotanteId(idAdotante, pageable);
        return animais.map(AnimalMapper::toResponse);
    }
}
