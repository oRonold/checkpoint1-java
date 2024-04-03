package br.com.fiap.livraria.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor

@Entity
@Table(name = "jv_tb_emprestimo")
public class Emprestimo {

    @Id
    @GeneratedValue
    @Column(name = "cd_emprestimo")
    private Long codigo;

    @Column(name = "dt_emprestimo", nullable = false)
    private LocalDateTime dataEmprestimo;

    @Column(name = "dt_devolucao", nullable = false)
    private LocalDateTime dataDevolucao;

    @Column(name = "st_emprestimo", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusEmprestimo status;

}
