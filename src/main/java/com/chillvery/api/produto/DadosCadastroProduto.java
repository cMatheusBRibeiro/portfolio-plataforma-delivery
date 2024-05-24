package com.chillvery.api.produto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroProduto(

    @NotBlank
    String nome,

    @NotNull
    Float preco

) {
}
