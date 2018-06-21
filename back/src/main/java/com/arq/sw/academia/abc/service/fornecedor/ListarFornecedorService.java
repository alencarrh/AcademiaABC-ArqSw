package com.arq.sw.academia.abc.service.fornecedor;

import com.arq.sw.academia.abc.dto.FornecedorDTO;
import com.arq.sw.academia.abc.entity.FornecedorEntity;
import com.arq.sw.academia.abc.mapper.dto.FornecedorDTOMapper;
import com.arq.sw.academia.abc.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Service
public class ListarFornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Autowired
    private FornecedorDTOMapper fornecedorMapper;


    public List<FornecedorDTO> listar() {
        List<FornecedorEntity> fornecedores = newArrayList(fornecedorRepository.findAll());
        return fornecedorMapper.map(fornecedores);
    }

}
