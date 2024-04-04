package br.com.fiap.livraria.model.livro.dto;

import br.com.fiap.livraria.model.livro.Genero;
import br.com.fiap.livraria.model.livro.Livro;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record DetalhesLivroDTO(Long codigo, String titulo, String numeroIsbn, Genero genero,
                               @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
                               LocalDateTime dataCadastro) {

    public DetalhesLivroDTO(Livro livro){
        this(livro.getCodigo(), livro.getTitulo(), livro.getIsbn(), livro.getGenero(), livro.getDataCadastro());
    }

}
