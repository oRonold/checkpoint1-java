package br.com.fiap.livraria.model.usuario.dto;

import br.com.fiap.livraria.model.emprestimo.dto.DetalhesEmprestimoDTO;
import br.com.fiap.livraria.model.emprestimo.dto.ListagemEmprestimoDTO;
import br.com.fiap.livraria.model.usuario.Usuario;

import java.util.ArrayList;
import java.util.stream.Collectors;

public record DetalhesUsuarioDTO(Long codigo, String nome, String email, ArrayList<ListagemEmprestimoDTO> emprestimos) {

    public DetalhesUsuarioDTO(Usuario usuario){
        this(usuario.getCodigo(), usuario.getNome(), usuario.getEmail(),
                new ArrayList<>(usuario.getEmprestimos().stream().map(emprestimo -> new ListagemEmprestimoDTO(emprestimo.getCodigo(), emprestimo.getDataEmprestimo(), emprestimo.getDataDevolucao(), emprestimo.getStatus())).collect(Collectors.toList())));
    }

}
