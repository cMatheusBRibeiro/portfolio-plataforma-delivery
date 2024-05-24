package com.chillvery.api.repository;

import com.chillvery.api.model.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    public Page<Produto> findAllByAtivoTrue(Pageable paginacao);
}
