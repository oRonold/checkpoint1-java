package br.com.fiap.livraria.model.editora.dto;

import br.com.fiap.livraria.model.editora.CategoriaEditora;
import br.com.fiap.livraria.model.editora.Editora;
import br.com.fiap.livraria.model.livro.Livro;

import java.util.List;

public record ListagemEditoraDTO(Long codigo, String nome, String telefone, String email, CategoriaEditora categoria) {

    public ListagemEditoraDTO(Editora editora){
        this(editora.getCodigo(), editora.getNome(), editora.getTelefone(), editora.getEmail(), editora.getCategoria());
    }


}
