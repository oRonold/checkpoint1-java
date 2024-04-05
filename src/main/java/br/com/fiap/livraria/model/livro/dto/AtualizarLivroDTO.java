package br.com.fiap.livraria.model.livro.dto;

import br.com.fiap.livraria.model.livro.Genero;
import jakarta.validation.constraints.NotNull;

public record AtualizarLivroDTO(
        @NotNull
        Long codigo,
        String titulo, String isbn, Genero genero) {
}
