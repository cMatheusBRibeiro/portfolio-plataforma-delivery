package com.chillvery.api.produto;

import com.chillvery.api.model.Produto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosListagemProduto(

    Long id,
    String nome,
    Float preco

) {
    public DadosListagemProduto(Produto produto) {
        this(
            produto.getId(),
            produto.getNome(),
            produto.getPreco()
        );
    }
}
