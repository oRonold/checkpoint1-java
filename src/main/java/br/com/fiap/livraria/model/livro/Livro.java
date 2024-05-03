package br.com.fiap.livraria.model.livro;

import br.com.fiap.livraria.model.editora.Editora;
import br.com.fiap.livraria.model.livro.dto.AtualizarLivroDTO;
import br.com.fiap.livraria.model.livro.dto.CadastrarLivroDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor

@Entity
@Table(name = "jv_tb_livro")
@EntityListeners(AuditingEntityListener.class)
public class Livro {

    @Id
    @GeneratedValue
    @Column(name = "cd_livro")
    private Long codigo;

    @Column(name = "nm_titulo", length = 100, nullable = false)
    private String titulo;

    @Column(name = "dt_cadastro", nullable = false)
    @CreatedDate
    private LocalDateTime dataCadastro;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cd_detalhes_livro", nullable = false)
    private DetalhesLivro detalhesLivro;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cd_editora", nullable = false)
    private Editora editora;

    public Livro(CadastrarLivroDTO dto){
        this.titulo = dto.titulo();
        detalhesLivro = new DetalhesLivro(dto);
        detalhesLivro.setLivro(this);
    }

    public void atualizar(AtualizarLivroDTO dto){
        if(dto.titulo() != null){
            this.titulo = dto.titulo();
        }
        detalhesLivro.atualizar(dto);
    }

}
