package com.chillvery.api.cliente;

import com.chillvery.api.model.Cliente;

public record DadosListagemCliente(
    String nome,
    String telefone,
    String email
) {
    public DadosListagemCliente(Cliente cliente) {
        this(
            cliente.getNome(),
            cliente.getTelefone(),
            cliente.getEmail()
        );
    }
}
