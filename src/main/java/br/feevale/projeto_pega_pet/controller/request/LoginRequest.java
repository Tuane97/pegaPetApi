package br.feevale.projeto_pega_pet.controller.request;

import jakarta.validation.constraints.Email;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LoginRequest {

    @Email
    private String email;

    private String senha;

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }
}
