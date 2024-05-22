package com.chillvery.api.controller;

import com.chillvery.api.cliente.DadosAtualizaCliente;
import com.chillvery.api.cliente.DadosCadastroCliente;
import com.chillvery.api.cliente.DadosListagemCliente;
import com.chillvery.api.model.Cliente;
import com.chillvery.api.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public Page<DadosListagemCliente> listarClientes(
       @PageableDefault Pageable paginacao
    ) {
        return this.clienteRepository.findAllByAtivoTrue(paginacao).map(DadosListagemCliente::new);
    }

    @PostMapping
    @Transactional
    public void adicionarCliente(@RequestBody @Valid DadosCadastroCliente dadosCadastroCliente) {
        this.clienteRepository.save(new Cliente(dadosCadastroCliente));
    }

    @PutMapping("/{id}")
    @Transactional
    public void atualizarCliente(
        @RequestBody @Valid DadosAtualizaCliente dadosAtualizaCliente,
        @PathVariable Long id
    ) {
        var cliente = this.clienteRepository.getReferenceById(id);
        cliente.atualizarInformacoes(dadosAtualizaCliente);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void removerCliente(@PathVariable Long id) {
        var cliente = this.clienteRepository.getReferenceById(id);
        cliente.remover();
    }

}
