package com.chillvery.api.model;

import com.chillvery.api.produto.DadosAtualizaProduto;
import com.chillvery.api.produto.DadosCadastroProduto;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "produto")
@Entity(name = "Produto")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(of = "id")
public class Produto {

    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "preco")
    private Float preco;

    @Column(name = "ativo")
    private Boolean ativo;

    public Produto(DadosCadastroProduto dadosCadastroProduto) {
        this.setNome(dadosCadastroProduto.nome());
        this.setPreco(dadosCadastroProduto.preco());
        this.setAtivo(true);
    }

    public void atualizarInformacoes(DadosAtualizaProduto dadosAtualizaProduto) {
        if (dadosAtualizaProduto.nome() != null) {
            this.setNome(dadosAtualizaProduto.nome());
        }

        if (dadosAtualizaProduto.preco() != null) {
            this.setPreco(dadosAtualizaProduto.preco());
        }
    }

    public void remover() {
        this.setAtivo(false);
    }

}
