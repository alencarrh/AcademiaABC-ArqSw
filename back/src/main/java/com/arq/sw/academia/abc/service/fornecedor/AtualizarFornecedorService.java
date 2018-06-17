package com.arq.sw.academia.abc.service.fornecedor;

import com.arq.sw.academia.abc.dto.FornecedorDTO;
import com.arq.sw.academia.abc.dto.request.fornecedor.AtualizarFornecedorRequest;
import com.arq.sw.academia.abc.entity.FornecedorEntity;
import com.arq.sw.academia.abc.exception.status.BadRequestException;
import com.arq.sw.academia.abc.exception.status.NotFoundException;
import com.arq.sw.academia.abc.mapper.dto.FornecedorDTOMapper;
import com.arq.sw.academia.abc.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.util.Objects.isNull;
import static org.apache.commons.lang3.StringUtils.isEmpty;

@Service
public class AtualizarFornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Autowired
    private FornecedorDTOMapper fornecedorMapper;

    public FornecedorDTO atualizar(final AtualizarFornecedorRequest request) {
        validar(request);

        Optional<FornecedorEntity> opFornecedor = fornecedorRepository.findById(request.getId());

        FornecedorEntity fornecedor = opFornecedor.<NotFoundException>orElseThrow(() -> {
            throw new NotFoundException("ID não corresponde a nenhum fornecedor.");
        });

        fornecedor.setNome(request.getNome());

        fornecedor = fornecedorRepository.save(fornecedor);

        return fornecedorMapper.map(fornecedor);
    }

    private void validar(final AtualizarFornecedorRequest request) {
        if(isNull(request)) {
            BadRequestException.throwNew("Request não pode ser nulo.");
        }

        if(isEmpty(request.getNome())) {
            BadRequestException.throwNew("Nome é obrigatório.");
        }

    }

}
