package com.arq.sw.academia.abc.repository;

import com.arq.sw.academia.abc.entity.FornecedorEntity;
import org.springframework.data.repository.CrudRepository;

public interface FornecedorRepository extends CrudRepository<FornecedorEntity, Long> {

    FornecedorEntity findByCnpj(String cnpj);

}
