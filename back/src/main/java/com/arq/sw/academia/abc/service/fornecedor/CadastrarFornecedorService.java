package com.arq.sw.academia.abc.service.fornecedor;

import com.arq.sw.academia.abc.dto.FornecedorDTO;
import com.arq.sw.academia.abc.dto.request.fornecedor.CadastrarFornecedorRequest;
import com.arq.sw.academia.abc.entity.FornecedorEntity;
import com.arq.sw.academia.abc.exception.status.BadRequestException;
import com.arq.sw.academia.abc.exception.status.PreconditionFailedException;
import com.arq.sw.academia.abc.mapper.dto.FornecedorDTOMapper;
import com.arq.sw.academia.abc.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;
import static java.util.Optional.ofNullable;
import static org.apache.commons.lang3.StringUtils.isEmpty;

@Service
public class CadastrarFornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Autowired
    private FornecedorDTOMapper fornecedorMapper;

    public FornecedorDTO cadastrar(final CadastrarFornecedorRequest request) {
        validar(request);

        FornecedorEntity fornecedor = FornecedorEntity.builder()
                                                      .nome(request.getNome())
                                                      .cnpj(request.getCnpj())
                                                      .build();

        fornecedor = fornecedorRepository.save(fornecedor);

        return fornecedorMapper.map(fornecedor);
    }

    private void validar(CadastrarFornecedorRequest request) {
        if(isNull(request)) {
            BadRequestException.throwNew("Request não pode ser nulo.");
        }

        if(isEmpty(request.getNome())) {
            BadRequestException.throwNew("Nome é obrigatório.");
        }

        if(isEmpty(request.getCnpj())) {
            BadRequestException.throwNew("CNPJ é obrigatório.");
        }

        if(ofNullable(fornecedorRepository.findByCnpj(request.getCnpj())).isPresent()) {
            PreconditionFailedException.throwNew("CNPJ já cadastrado.");
        }
    }
}
