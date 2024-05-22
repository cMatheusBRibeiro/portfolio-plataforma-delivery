package com.chillvery.api.controller;

import com.chillvery.api.funcionario.DadosAtualizaFuncionario;
import com.chillvery.api.funcionario.DadosCadastroFuncionario;
import com.chillvery.api.funcionario.DadosListagemFuncionario;
import com.chillvery.api.model.Funcionario;
import com.chillvery.api.repository.FuncionarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @GetMapping
    public Page<DadosListagemFuncionario> listarFuncionarios(
        @PageableDefault(size = 10) Pageable paginacao
    ) {
        return this.funcionarioRepository.findAllByAtivoTrue(paginacao).map(DadosListagemFuncionario::new);
    }

    @PostMapping
    @Transactional
    public void adicionarFuncionario(@RequestBody @Valid DadosCadastroFuncionario dadosCadastroFuncionario) {
        this.funcionarioRepository.save(new Funcionario(dadosCadastroFuncionario));
    }

    @PutMapping("/{id}")
    public void atualizarFuncionario(
        @RequestBody @Valid DadosAtualizaFuncionario dadosAtualizaFuncionario,
        @PathVariable Long id
    ) {
        var funcionario = this.funcionarioRepository.getReferenceById(id);
        funcionario.atualizarInformacoes(dadosAtualizaFuncionario);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void removerFuncionario(@PathVariable Long id) {
        var funcionario = this.funcionarioRepository.getReferenceById(id);
        funcionario.remover();
    }

}
