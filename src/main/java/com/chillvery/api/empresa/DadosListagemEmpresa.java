package com.chillvery.api.empresa;

import com.chillvery.api.endereco.DadosEndereco;
import com.chillvery.api.model.Empresa;

public record DadosListagemEmpresa(
    Long id,
    String razaoSocial,
    String nomeFantasia,
    String cnpj,
    DadosEndereco endereco
) {
    public DadosListagemEmpresa(Empresa empresa) {
        this(
            empresa.getId(),
            empresa.getRazaoSocial(),
            empresa.getNomeFantasia(),
            empresa.getCnpj(),
            new DadosEndereco(empresa.getEndereco())
        );
    }
}
