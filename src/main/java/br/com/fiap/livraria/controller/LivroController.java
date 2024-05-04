package br.com.fiap.livraria.controller;

import br.com.fiap.livraria.model.editora.dto.DetalhesLivroEditoraDTO;
import br.com.fiap.livraria.model.livro.Livro;
import br.com.fiap.livraria.model.livro.dto.AtualizarLivroDTO;
import br.com.fiap.livraria.model.livro.dto.CadastrarLivroDTO;
import br.com.fiap.livraria.model.livro.dto.ListagemLivroDTO;
import br.com.fiap.livraria.model.livro.dto.DetalhesLivroDTO;
import br.com.fiap.livraria.repository.EditoraRepository;
import br.com.fiap.livraria.repository.LivroRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private EditoraRepository editoraRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesLivroDTO> cadastrar(@RequestBody CadastrarLivroDTO dto, UriComponentsBuilder builder){
        var livro = new Livro(dto);
        livroRepository.save(livro);
        var uri = builder.path("/{id}").buildAndExpand(livro.getCodigo()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesLivroDTO(livro));
    }

    @GetMapping
    public ResponseEntity<Page<ListagemLivroDTO>> listar(@PageableDefault(sort = {"titulo"}) Pageable pageable){
        var page = livroRepository.findAll(pageable).map(ListagemLivroDTO::new);
        return ResponseEntity.ok(page);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<DetalhesLivroDTO> buscarPorId(@PathVariable Long id){
        var livro = livroRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesLivroDTO(livro));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DetalhesLivroDTO> atualizar(@RequestBody @Valid AtualizarLivroDTO dto, @PathVariable Long id){
        var livro = livroRepository.getReferenceById(id);
        livro.atualizar(dto);
        return ResponseEntity.ok().body(new DetalhesLivroDTO(livro));
    }

    @PutMapping("{idLivro}/editoras/{idEditora}")
    @Transactional
    public ResponseEntity<DetalhesLivroEditoraDTO> incluirEditora(@PathVariable("idLivro") Long idLivro, @PathVariable("idEditora") Long idEditora){
        var livro = livroRepository.getReferenceById(idLivro);
        var editora = editoraRepository.getReferenceById(idEditora);
        livro.setEditora(editora);
        return ResponseEntity.ok().body(new DetalhesLivroEditoraDTO(livro));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        var post = livroRepository.getReferenceById(id);
        livroRepository.delete(post);
        return ResponseEntity.noContent().build();
    }

}
