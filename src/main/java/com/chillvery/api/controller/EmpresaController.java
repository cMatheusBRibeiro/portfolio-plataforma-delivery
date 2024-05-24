package com.chillvery.api.controller;

import com.chillvery.api.empresa.DadosAtualizarEmpresa;
import com.chillvery.api.empresa.DadosCadastroEmpresa;
import com.chillvery.api.empresa.DadosListagemEmpresa;
import com.chillvery.api.model.Empresa;
import com.chillvery.api.repository.EmpresaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("empresas")
public class EmpresaController {

    @Autowired
    private EmpresaRepository repository;

    @GetMapping
    public Page<DadosListagemEmpresa> listarEmpresas(
        @PageableDefault(size = 10, sort = {"nomeFantasia"}) Pageable paginacao
    ) {
        return this.repository.findAllByAtivoTrue(paginacao).map(DadosListagemEmpresa::new);
    }

    @PostMapping
    @Transactional
    public void adicionarEmpresa(@RequestBody @Valid DadosCadastroEmpresa dadosCadastroEmpresa) {
        this.repository.save(new Empresa(dadosCadastroEmpresa));
    }

    @PutMapping("/{id}")
    @Transactional
    public void atualizaEmpresa(
        @RequestBody @Valid DadosAtualizarEmpresa dadosAtualizarEmpresa,
        @PathVariable Long id
    ) {
        var empresa = this.repository.getReferenceById(id);
        empresa.atualizarInformacoes(dadosAtualizarEmpresa);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void removerEmpresa(@PathVariable Long id) {
        var empresa = this.repository.getReferenceById(id);
        empresa.remover();
    }

}
