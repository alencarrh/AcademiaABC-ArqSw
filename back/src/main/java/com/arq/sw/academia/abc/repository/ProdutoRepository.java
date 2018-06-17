package com.arq.sw.academia.abc.repository;

import com.arq.sw.academia.abc.entity.ProdutoEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProdutoRepository extends CrudRepository<ProdutoEntity, Long> {

    List<ProdutoEntity> findByFornecedorId(final Long id);

}
