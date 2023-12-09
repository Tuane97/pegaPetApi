package br.feevale.projeto_pega_pet.controller.response;

import br.feevale.projeto_pega_pet.domain.Animal;
import lombok.*;

import java.util.List;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioResponse {

    private Long idUsuario;
    private String nome;
    private String email;
    private String foto;
    private String cnpj;
    private String preferencias;
    private List<ContatoResponse> contatos;
    private List<Animal> animais;

}
