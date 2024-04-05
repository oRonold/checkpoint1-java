package br.com.fiap.livraria.model.livro.dto;

import br.com.fiap.livraria.model.livro.Genero;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CadastrarLivroDTO(
        @NotBlank
        String titulo,
        @NotBlank
        String numeroIsbn,
        @NotNull
        Genero genero) {
}
