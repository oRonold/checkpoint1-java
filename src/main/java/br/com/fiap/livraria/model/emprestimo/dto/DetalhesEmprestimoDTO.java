package br.com.fiap.livraria.model.emprestimo.dto;

import br.com.fiap.livraria.model.emprestimo.Emprestimo;
import br.com.fiap.livraria.model.emprestimo.StatusEmprestimo;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record DetalhesEmprestimoDTO(Long codigo,
                                    @JsonFormat(pattern = "dd/MM/yyyy")
                                    LocalDate dataEmprestimo,
                                    @JsonFormat(pattern = "dd/MM/yyyy")
                                    LocalDate dataDevolucao, StatusEmprestimo status) {

    public DetalhesEmprestimoDTO(Emprestimo emprestimo){
        this(emprestimo.getCodigo(), emprestimo.getDataEmprestimo(), emprestimo.getDataDevolucao(), emprestimo.getStatus());
    }

}
