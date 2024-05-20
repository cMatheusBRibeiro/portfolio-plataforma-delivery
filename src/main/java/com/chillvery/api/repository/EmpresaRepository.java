package com.chillvery.api.repository;

import com.chillvery.api.model.Empresa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    Page<Empresa> findAllByAtivoTrue(Pageable paginacao);
}
