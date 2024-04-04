package br.com.fiap.livraria.model.autor;

import br.com.fiap.livraria.model.autor.dto.AtualizarAutorDTO;
import br.com.fiap.livraria.model.autor.dto.CadastrarAutorDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor

@Entity
@Table(name = "jv_tb_autor")
@EntityListeners(AuditingEntityListener.class)
public class Autor {

    @Id
    @GeneratedValue
    @Column(name = "cd_autor")
    private Long codigo;

    @Column(name = "nm_autor", length = 100, nullable = false)
    private String nome;

    @Column(name = "dt_cadastro", nullable = false)
    @CreatedDate
    private LocalDateTime dataCadastro;

    @Column(name = "ds_biografia", length = 100, nullable = false)
    private String biografia;

    @Column(name = "ds_email", length = 100, nullable = false)
    private String email;

    @Column(name = "dt_nascimento", nullable = false)
    private LocalDate dataNascimento;

    public Autor(CadastrarAutorDTO dto){
        this.nome = dto.nome();
        this.biografia = dto.biografia();
        this.email = dto.email();
        this.dataNascimento = dto.dataNascimento();
    }

    public void atualizar(AtualizarAutorDTO dto){
        if(dto.nome() != null){
            this.nome = dto.nome();
        }
        if(dto.biografia() != null){
            this.biografia = dto.biografia();
        }
        if(dto.email() != null){
            this.email = dto.email();
        }
        if(dto.dataNascimento() != null){
            this.dataNascimento = dto.dataNascimento();
        }
    }

}
