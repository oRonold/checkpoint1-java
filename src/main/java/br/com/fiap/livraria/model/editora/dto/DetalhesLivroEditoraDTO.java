package br.com.fiap.livraria.model.editora.dto;

import br.com.fiap.livraria.model.livro.Livro;

public record DetalhesLivroEditoraDTO(Long codigo, String titulo, String sinopse, String isbn, ListagemEditoraDTO editora) {

    public DetalhesLivroEditoraDTO(Livro livro){
        this(livro.getCodigo(), livro.getTitulo(), livro.getDetalhesLivro().getSinopse(), livro.getDetalhesLivro().getIsbn(), new ListagemEditoraDTO(livro.getEditora()));
    }

}
