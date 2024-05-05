package br.com.fiap.livraria.model.usuario;

import br.com.fiap.livraria.model.emprestimo.Emprestimo;
import br.com.fiap.livraria.model.emprestimo.StatusEmprestimo;
import br.com.fiap.livraria.model.emprestimo.dto.CriarEmprestimoDTO;
import br.com.fiap.livraria.model.usuario.dto.AtualizarUsuarioDTO;
import br.com.fiap.livraria.model.usuario.dto.CadastrarUsuarioDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "jv_tb_usuario")
@EntityListeners(AuditingEntityListener.class)
public class Usuario {

    @Id
    @GeneratedValue
    @Column(name = "cd_usuario")
    private Long codigo;

    @Column(name = "nm_usuario", length = 100, nullable = false)
    private String nome;

    @Column(name = "ds_email", length = 100, nullable = false, unique = true)
    private String email;

    @Column(name = "ds_senha", length = 10, nullable = false, unique = true)
    private String senha;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Emprestimo> emprestimos;

    public Usuario(CadastrarUsuarioDTO dto) {
        this.nome = dto.nome();
        this.email = dto.email();
        this.senha = dto.senha();
    }

    public void atualizar(AtualizarUsuarioDTO dto){
        if(dto.nome() != null){
            this.nome = dto.nome();
        }
        if(dto.email() != null){
            this.email = dto.email();
        }
        if(dto.senha() != null){
            this.senha = dto.senha();
        }
    }

}
