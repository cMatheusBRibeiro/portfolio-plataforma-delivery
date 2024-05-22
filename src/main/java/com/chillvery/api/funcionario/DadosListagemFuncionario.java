package com.chillvery.api.funcionario;

import com.chillvery.api.model.Funcionario;

public record DadosListagemFuncionario(
    Long id,
    String nome,
    String login,
    String email,
    Tipo tipo
) {

    public DadosListagemFuncionario(Funcionario funcionario) {
        this(
            funcionario.getId(),
            funcionario.getNome(),
            funcionario.getLogin(),
            funcionario.getEmail(),
            funcionario.getTipo()
        );
    }

}
