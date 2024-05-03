package br.com.fiap.livraria.model.livro.dto;

import br.com.fiap.livraria.model.livro.DetalhesLivro;
import br.com.fiap.livraria.model.livro.Genero;
import br.com.fiap.livraria.model.livro.Livro;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ExibirLivroDTO(Long codigo, String titulo,
                               @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
                               LocalDateTime dataCadastro, DetalhesLivroDTO detalhesLivro) {

    public ExibirLivroDTO(Livro livro){
        this(livro.getCodigo(), livro.getTitulo(), livro.getDataCadastro(), new DetalhesLivroDTO(livro.getDetalhesLivro()));
    }
}
