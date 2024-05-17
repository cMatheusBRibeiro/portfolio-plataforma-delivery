package com.chillvery.api.controller;

import com.chillvery.api.empresa.DadosCadastroEmpresa;
import com.chillvery.api.empresa.DadosListagemEmpresa;
import com.chillvery.api.model.Empresa;
import com.chillvery.api.repository.EmpresaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("empresas")
public class EmpresaController {

    @Autowired
    private EmpresaRepository repository;

    @GetMapping
    public List<DadosListagemEmpresa> listarEmpresas() {
        return this.repository.findAll().stream().map(DadosListagemEmpresa::new).toList();
    }

    @PostMapping
    @Transactional
    public void adicionarEmpresa(@RequestBody DadosCadastroEmpresa dadosCadastroEmpresa) {
        this.repository.save(new Empresa(dadosCadastroEmpresa));
    }

}
