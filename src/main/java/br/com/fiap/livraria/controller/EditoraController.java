package br.com.fiap.livraria.controller;

import br.com.fiap.livraria.model.editora.Editora;
import br.com.fiap.livraria.model.editora.dto.AtualizarEditoraDTO;
import br.com.fiap.livraria.model.editora.dto.CadastrarEditoraDTO;
import br.com.fiap.livraria.model.editora.dto.DetalhesEditoraDTO;
import br.com.fiap.livraria.model.editora.dto.ListagemEditoraDTO;
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
@RequestMapping("/editoras")
public class EditoraController {

    @Autowired
    private EditoraRepository repository;

    @Autowired
    private LivroRepository livroRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesEditoraDTO> cadastrar(@RequestBody CadastrarEditoraDTO dto, UriComponentsBuilder builder){
        var editora = new Editora(dto);
        repository.save(editora);
        var uri = builder.path("/{id}").buildAndExpand(editora.getCodigo()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesEditoraDTO(editora));
    }

    @GetMapping
    public ResponseEntity<Page<ListagemEditoraDTO>> listar(@PageableDefault(sort = {"nome"}) Pageable pageable){
        var page = repository.findAll(pageable).map(ListagemEditoraDTO::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhesEditoraDTO> buscarPorId(@PathVariable Long id){
        var editora = repository.getReferenceById(id);
        return ResponseEntity.ok().body(new DetalhesEditoraDTO(editora));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DetalhesEditoraDTO> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizarEditoraDTO dto){
        var editora = repository.getReferenceById(id);
        editora.atualizarInformacoes(dto);
        return ResponseEntity.ok().body(new DetalhesEditoraDTO(editora));
    }

    @DeleteMapping("/{idLivro}/livros/")
    @Transactional
    public ResponseEntity<Void> removerLivro(@PathVariable Long idLivro){
        var livro = livroRepository.getReferenceById(idLivro);
        livro.setEditora(null);
        livroRepository.save(livro);
        return ResponseEntity.noContent().build();
    }

}
