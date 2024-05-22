package com.chillvery.api.usuario;

import com.chillvery.api.funcionario.DadosCadastroFuncionario;

public record DadosCadastroUsuario(
    String nome,
    String login,
    String senha,
    String email,
    String telefone
) {

    public DadosCadastroUsuario(DadosCadastroFuncionario dadosCadastroFuncionario) {
        this(
            dadosCadastroFuncionario.nome(),
            dadosCadastroFuncionario.login(),
            dadosCadastroFuncionario.senha(),
            dadosCadastroFuncionario.email(),
            dadosCadastroFuncionario.telefone()
        );
    }

}
