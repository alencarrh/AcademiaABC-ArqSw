package com.arq.sw.academia.abc.service.fornecedor;

import com.arq.sw.academia.abc.dto.FornecedorDTO;
import com.arq.sw.academia.abc.entity.FornecedorEntity;
import com.arq.sw.academia.abc.exception.status.BadRequestException;
import com.arq.sw.academia.abc.exception.status.NotFoundException;
import com.arq.sw.academia.abc.mapper.dto.FornecedorDTOMapper;
import com.arq.sw.academia.abc.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.util.Objects.isNull;

@Service
public class ConsultarFornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Autowired
    private FornecedorDTOMapper fornecedorMapper;

    public FornecedorDTO consultar(final Long id) {
        if(isNull(id)) {
            BadRequestException.throwNew("ID não pode ser nulo.");
        }
        Optional<FornecedorEntity> opFornecedor = fornecedorRepository.findById(id);

        FornecedorEntity fornecedor = opFornecedor.<NotFoundException>orElseThrow(() -> {
            throw new NotFoundException("ID não corresponde a nenhum fornecedor.");
        });

        return fornecedorMapper.map(fornecedor);
    }

}
