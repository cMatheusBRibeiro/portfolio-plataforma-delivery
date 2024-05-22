package com.chillvery.api.usuario;

import com.chillvery.api.cliente.DadosAtualizaCliente;
import com.chillvery.api.funcionario.DadosAtualizaFuncionario;

public record DadosAtualizaUsuario(

    String nome,

    String login,

    String email,

    String telefone
) {

    public DadosAtualizaUsuario(DadosAtualizaFuncionario dadosAtualizaFuncionario) {
        this(
            dadosAtualizaFuncionario.nome(),
            dadosAtualizaFuncionario.login(),
            dadosAtualizaFuncionario.email(),
            dadosAtualizaFuncionario.telefone()
        );
    }

    public DadosAtualizaUsuario(DadosAtualizaCliente dadosAtualizaCliente) {
        this(
            dadosAtualizaCliente.nome(),
            dadosAtualizaCliente.login(),
            dadosAtualizaCliente.email(),
            dadosAtualizaCliente.telefone()
        );
    }
}
