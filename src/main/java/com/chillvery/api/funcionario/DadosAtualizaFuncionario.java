package com.chillvery.api.funcionario;

import jakarta.validation.constraints.Pattern;

public record DadosAtualizaFuncionario(

    String nome,

    String login,

    String email,

    @Pattern(regexp = "\\(?\\d{2}\\)?\\d{5}\\-?\\d{4}")
    String telefone,

    Tipo tipo
) { }
