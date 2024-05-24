package com.chillvery.api.controller;

import com.chillvery.api.model.Produto;
import com.chillvery.api.produto.DadosAtualizaProduto;
import com.chillvery.api.produto.DadosCadastroProduto;
import com.chillvery.api.produto.DadosListagemProduto;
import com.chillvery.api.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public Page<DadosListagemProduto> listarProdutos(
        @PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao
    ) {
        return this.produtoRepository.findAllByAtivoTrue(paginacao).map(DadosListagemProduto::new);
    }

    @PostMapping
    @Transactional
    public void cadastrarProduto(@RequestBody DadosCadastroProduto dadosCadastroProduto) {
        this.produtoRepository.save(new Produto(dadosCadastroProduto));
    }

    @PutMapping("/{id}")
    @Transactional
    public void atualizarProduto(
        @RequestBody DadosAtualizaProduto dadosAtualizaProduto,
        @PathVariable Long id
    ) {
        var produto = this.produtoRepository.getReferenceById(id);
        produto.atualizarInformacoes(dadosAtualizaProduto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void removerProduto(@PathVariable Long id) {
        var produto = this.produtoRepository.getReferenceById(id);
        produto.remover();
    }

}
