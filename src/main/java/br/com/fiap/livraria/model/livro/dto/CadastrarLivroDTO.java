package br.com.fiap.livraria.model.livro.dto;

import br.com.fiap.livraria.model.livro.Genero;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record CadastrarLivroDTO(
        @NotEmpty
        String titulo,
        @NotEmpty
        @Size(max = 13)
        String numeroIsbn,
        @NotEmpty
        String sinopse,
        @NotNull
        LocalDate dataPublicacao,
        @NotNull
        Genero genero) {
}
