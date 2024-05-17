package com.chillvery.api.empresa;

import com.chillvery.api.endereco.DadosEndereco;
import jakarta.persistence.Embedded;

public record DadosCadastroEmpresa(
        String razaoSocial,
        String nomeFantasia,
        String cnpj,

        @Embedded
        DadosEndereco endereco
) {}
