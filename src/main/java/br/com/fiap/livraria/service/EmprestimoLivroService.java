package br.com.fiap.livraria.service;

import br.com.fiap.livraria.exception.ValidacaoException;
import br.com.fiap.livraria.model.emprestimo.Emprestimo;
import br.com.fiap.livraria.model.emprestimo.StatusEmprestimo;
import br.com.fiap.livraria.model.emprestimo.dto.CriarEmprestimoDTO;
import br.com.fiap.livraria.repository.EmprestimoRepository;
import br.com.fiap.livraria.repository.LivroRepository;
import br.com.fiap.livraria.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmprestimoLivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Emprestimo criarEmprestimo(Long idLivro, Long idUsuario, CriarEmprestimoDTO dto){
         if(!livroRepository.existsById(idLivro)){
            throw new ValidacaoException("O Livro informado não existe");
         }
         if(!usuarioRepository.existsById(idUsuario)){
            throw new ValidacaoException("O Usuario informado não existe");
         }
         var emprestimo = new Emprestimo(dto);
         var usuario = usuarioRepository.getReferenceById(idUsuario);

         emprestimo.setUsuario(usuario);
         emprestimo.setStatus(StatusEmprestimo.valueOf("EMPRESTADO"));

         var livro = livroRepository.getReferenceById(idLivro);
         livro.getEmprestimos().add(emprestimo);
         emprestimo.getLivros().add(livro);

         livroRepository.save(livro);
         emprestimoRepository.save(emprestimo);

         return emprestimo;
    }

    public Emprestimo adicionarMaisLivrosAoEmprestimo(Long idLivro, Long idEmprestimo){
        if(!emprestimoRepository.existsById(idEmprestimo)){
            throw new ValidacaoException("O Emprestimo informado não existe");
        }
        if(!livroRepository.existsById(idLivro)){
            throw new ValidacaoException("O Livro informado não existe");
        }
        var emprestimo = emprestimoRepository.getReferenceById(idEmprestimo);
        var livro = livroRepository.getReferenceById(idLivro);

        emprestimo.getLivros().add(livro);

        return emprestimo;
    }

}
