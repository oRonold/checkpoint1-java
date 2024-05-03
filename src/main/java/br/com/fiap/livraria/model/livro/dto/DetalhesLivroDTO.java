package br.com.fiap.livraria.model.livro.dto;

import br.com.fiap.livraria.model.livro.DetalhesLivro;
import br.com.fiap.livraria.model.livro.Genero;
import br.com.fiap.livraria.model.livro.Livro;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record DetalhesLivroDTO(Long codigo, String isbn, String sinopse,
                               @JsonFormat(pattern = "dd/MM/yyyy")
                               LocalDate dataPublicacao, Genero genero) {

    public DetalhesLivroDTO(DetalhesLivro detalhesLivro){
        this(detalhesLivro.getCodigo(), detalhesLivro.getIsbn(), detalhesLivro.getSinopse(), detalhesLivro.getDataPublicacao(), detalhesLivro.getGenero());
    }

}
