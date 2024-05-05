package br.com.fiap.livraria.model.usuario.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record CadastrarUsuarioDTO(
        @NotEmpty
        @Size(max = 100)
        String nome,
        @Size(max = 100)
        @NotEmpty
        @Email
        String email,
        @Size(max = 10)
        @NotEmpty
        String senha) {
}
