package br.com.fiap.livraria.model.livro.dto;

import br.com.fiap.livraria.model.livro.Genero;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record AtualizarLivroDTO(
        @Size(max = 100)
        String titulo,
        @Size(max = 13)
        String numeroIsbn,
        @Size(max = 100)
        String sinopse,
        LocalDate dataPublicacao,
        Genero genero) {
}
