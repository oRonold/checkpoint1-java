package br.com.fiap.livraria.model.livro.dto;

import br.com.fiap.livraria.model.editora.CategoriaEditora;
import br.com.fiap.livraria.model.editora.dto.CadastrarEditoraDTO;
import br.com.fiap.livraria.model.livro.Genero;
import jakarta.validation.constraints.*;

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
