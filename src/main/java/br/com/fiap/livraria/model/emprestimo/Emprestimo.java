package br.com.fiap.livraria.model.emprestimo;

import br.com.fiap.livraria.model.emprestimo.dto.AtualizarEmprestimoDTO;
import br.com.fiap.livraria.model.emprestimo.dto.CriarEmprestimoDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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
    private LocalDate dataEmprestimo;

    @Column(name = "dt_devolucao", nullable = false)
    private LocalDate dataDevolucao;

    @Column(name = "st_emprestimo", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusEmprestimo status;

    public Emprestimo(CriarEmprestimoDTO dto){
        this.dataEmprestimo = dto.dataEmprestimo();
        this.dataDevolucao = dto.dataDevolucao();
        this.status = dto.status();
    }

    public void atualizar(AtualizarEmprestimoDTO dto){
        if(dto.status() != null){
            this.status = dto.status();
        }
    }

}
