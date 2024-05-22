package com.chillvery.api.usuario;

import com.chillvery.api.funcionario.DadosAtualizaFuncionario;
import jakarta.validation.constraints.Pattern;

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

}
