package com.chillvery.api.model;

import com.chillvery.api.endereco.DadosEndereco;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    @Column(name = "cep")
    private String cep;

    @Column(name = "logradouro")
    private String logradouro;

    @Column(name = "bairro")
    private String bairro;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "uf")
    private String uf;

    @Column(name = "numero")
    private Integer numero;

    @Column(name = "complemento")
    private String complemento;

    public Endereco(DadosEndereco dadosEndereco) {
        this.setCep(dadosEndereco.cep());
        this.setLogradouro(dadosEndereco.logradouro());
        this.setBairro(dadosEndereco.bairro());
        this.setCidade(dadosEndereco.cidade());
        this.setUf(dadosEndereco.uf());
        this.setNumero(dadosEndereco.numero());
        this.setComplemento(dadosEndereco.complemento());
    }

    public void atualizarEndereco(DadosEndereco dadosEndereco) {
        if (dadosEndereco.cep() != null) {
            this.setCep(dadosEndereco.cep());
        }
        
        if (dadosEndereco.logradouro() != null) {
            this.setLogradouro(dadosEndereco.logradouro());
        }
        
        if (dadosEndereco.bairro() != null) {
            this.setBairro(dadosEndereco.bairro());
        }
        
        if (dadosEndereco.cidade() != null) {
            this.setCidade(dadosEndereco.cidade());
        }
        
        if (dadosEndereco.uf() != null) {
            this.setUf(dadosEndereco.uf());
        }
        
        if (dadosEndereco.numero() != null) {
            this.setNumero(dadosEndereco.numero());
        }
        
        if (dadosEndereco.complemento() != null) {
            this.setComplemento(dadosEndereco.complemento());
        }
    }
}
