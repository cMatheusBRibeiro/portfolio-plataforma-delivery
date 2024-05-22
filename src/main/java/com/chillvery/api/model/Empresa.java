package com.chillvery.api.model;


import com.chillvery.api.empresa.DadosAtualizarEmpresa;
import com.chillvery.api.empresa.DadosCadastroEmpresa;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "empresa")
@Entity(name = "Empresa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "razao_social")
    private String razaoSocial;

    @Column(name = "nome_fantasia")
    private String nomeFantasia;

    @Column(name = "cnpj")
    private String cnpj;

    @Embedded
    private Endereco endereco;

    @Column(name = "ativo")
    private Boolean ativo;

    public Empresa(DadosCadastroEmpresa dadosCadastroEmpresa) {
        this.setRazaoSocial(dadosCadastroEmpresa.razaoSocial());
        this.setNomeFantasia(dadosCadastroEmpresa.nomeFantasia());
        this.setCnpj(dadosCadastroEmpresa.cnpj());
        this.setEndereco(new Endereco(dadosCadastroEmpresa.endereco()));
        this.setAtivo(true);
    }

    public void atualizarInformacoes(DadosAtualizarEmpresa dadosAtualizarEmpresa) {
        if (dadosAtualizarEmpresa.razaoSocial() != null) {
            this.setRazaoSocial(dadosAtualizarEmpresa.razaoSocial());
        }

        if (dadosAtualizarEmpresa.nomeFantasia() != null) {
            this.setNomeFantasia(dadosAtualizarEmpresa.nomeFantasia());
        }

        if (dadosAtualizarEmpresa.cnpj() != null) {
            this.setCnpj(dadosAtualizarEmpresa.cnpj());
        }

        if (dadosAtualizarEmpresa.endereco() != null) {
            this.getEndereco().atualizarEndereco(dadosAtualizarEmpresa.endereco());
        }
    }

    public void remover() {
        this.setAtivo(false);
    }

}
