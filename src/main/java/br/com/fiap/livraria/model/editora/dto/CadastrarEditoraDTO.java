package br.com.fiap.livraria.model.editora.dto;

import br.com.fiap.livraria.model.editora.CategoriaEditora;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CadastrarEditoraDTO(
        @NotBlank
        String nome,
        @NotBlank
        String telefone,
        @NotBlank
        @Email
        String email,
        @NotNull
        CategoriaEditora categoria) {
}
