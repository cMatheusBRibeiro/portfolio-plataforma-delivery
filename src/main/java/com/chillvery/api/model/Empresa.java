package com.chillvery.api.model;


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
        this.razaoSocial = dadosCadastroEmpresa.razaoSocial();
        this.nomeFantasia = dadosCadastroEmpresa.nomeFantasia();
        this.cnpj = dadosCadastroEmpresa.cnpj();
        this.endereco = new Endereco(dadosCadastroEmpresa.endereco());
        this.ativo = true;
    }
}
