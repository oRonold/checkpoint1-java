package br.com.fiap.livraria.model.autor.dto;

import br.com.fiap.livraria.model.usuario.Usuario;

public record ListagemUsuarioDTO(Long codigo, String nome, String email) {

    public ListagemUsuarioDTO(Usuario usuario){
        this(usuario.getCodigo(), usuario.getNome(), usuario.getEmail());
    }

}
