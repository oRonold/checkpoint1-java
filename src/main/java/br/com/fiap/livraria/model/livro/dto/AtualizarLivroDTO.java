package br.com.fiap.livraria.model.livro.dto;

import br.com.fiap.livraria.model.livro.Genero;

public record AtualizarLivroDTO(Long codigo, String titulo, String isbn, Genero genero) {
}
