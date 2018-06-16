package com.arq.sw.academia.abc.service.usuario;

import com.arq.sw.academia.abc.dto.UsuarioDTO;
import com.arq.sw.academia.abc.dto.request.usuario.CadastrarUsuarioRequest;
import com.arq.sw.academia.abc.entity.UsuarioEntity;
import com.arq.sw.academia.abc.exception.status.BadRequestException;
import com.arq.sw.academia.abc.mapper.dto.UsuarioDTOMapper;
import com.arq.sw.academia.abc.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;
import static org.apache.commons.lang3.StringUtils.isEmpty;

@Service
public class CadastrarUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioDTOMapper mapper;

    public UsuarioDTO cadastrar(CadastrarUsuarioRequest request) {
        validar(request);
        UsuarioEntity usuario = UsuarioEntity.builder()
                                             .nome(request.getNome())
                                             .cpf(request.getCpf())
                                             .dataNascimento(request.getDataNascimento())
                                             .build();

        usuario = usuarioRepository.save(usuario);

        return mapper.map(usuario);
    }

    private void validar(CadastrarUsuarioRequest request) {
        if(isNull(request)) {
            throw new BadRequestException("RequestBody não pode ser nulo");
        }
        if(isEmpty(request.getNome())) {
            throw new BadRequestException("Nome é obrigatório e não pode ser nulo.");
        }
        if(isEmpty(request.getCpf())) {
            throw new BadRequestException("CPF é obrigatório e não pode ser nulo.");
        }
        if(isNull(request.getDataNascimento())) {
            throw new BadRequestException("Data de Nascimento é obrigatório e não pode ser nulo.");
        }
    }

}
