package com.chillvery.api.funcionario;

import jakarta.validation.constraints.*;

public record DadosCadastroFuncionario(

    @NotBlank
    String nome,

    @NotBlank
    String login,

    @NotBlank
    @Size(min = 6, message = "A senha precisa ter, no mínimo, 6 caracteres.")
    String senha,

    @NotBlank
    String email,

    @NotBlank
    @Pattern(regexp = "\\(?\\d{2}\\)?\\d{5}\\-?\\d{4}")
    String telefone,

    @NotNull
    Tipo tipo
) { }
