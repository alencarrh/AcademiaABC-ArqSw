package com.arq.sw.academia.abc.service.usuario;

import com.arq.sw.academia.abc.dto.UsuarioDTO;
import com.arq.sw.academia.abc.dto.request.usuario.AtualizarUsuarioRequest;
import com.arq.sw.academia.abc.entity.UsuarioEntity;
import com.arq.sw.academia.abc.exception.status.BadRequestException;
import com.arq.sw.academia.abc.exception.status.NotFoundException;
import com.arq.sw.academia.abc.exception.status.PreconditionFailedException;
import com.arq.sw.academia.abc.mapper.dto.UsuarioDTOMapper;
import com.arq.sw.academia.abc.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.util.Objects.isNull;
import static org.apache.commons.lang3.BooleanUtils.isFalse;
import static org.apache.commons.lang3.StringUtils.isEmpty;

@Service
public class AtualizarUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioDTOMapper usuarioMapper;

    public UsuarioDTO atualizar(final AtualizarUsuarioRequest request) {
        validar(request);

        Optional<UsuarioEntity> opUsuario = usuarioRepository.findById(request.getId());

        UsuarioEntity usuario = opUsuario.<NotFoundException>orElseThrow(() -> {
            throw new NotFoundException("ID não corresponde a nenhum fornecedor.");
        });

        usuario.setNome(request.getNome());
        usuario.setDataNascimento(request.getDataNascimento());

        usuario = usuarioRepository.save(usuario);

        return usuarioMapper.map(usuario);
    }

    private void validar(final AtualizarUsuarioRequest request) {
        if(isNull(request)) {
            BadRequestException.throwNew("Request não pode ser nulo.");
        }

        if(isNull(request.getId())) {
            BadRequestException.throwNew("ID é obrigatório.");
        }

        if(isEmpty(request.getNome())) {
            BadRequestException.throwNew("Nome é obrigatório.");
        }

        if(isNull(request.getDataNascimento())) {
            BadRequestException.throwNew("Data de nascimento é obrigatório.");
        }

        if(isFalse(usuarioRepository.existsById(request.getId()))) {
            PreconditionFailedException.throwNew("ID não corresponde a nenhum usuário");
        }
    }

}
