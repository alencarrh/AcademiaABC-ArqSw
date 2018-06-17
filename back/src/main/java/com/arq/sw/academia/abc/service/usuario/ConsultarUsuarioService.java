package com.arq.sw.academia.abc.service.usuario;

import com.arq.sw.academia.abc.dto.UsuarioDTO;
import com.arq.sw.academia.abc.entity.UsuarioEntity;
import com.arq.sw.academia.abc.exception.status.BadRequestException;
import com.arq.sw.academia.abc.exception.status.NotFoundException;
import com.arq.sw.academia.abc.mapper.dto.UsuarioDTOMapper;
import com.arq.sw.academia.abc.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.util.Objects.isNull;

@Service
public class ConsultarUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioDTOMapper usuarioMapper;

    public UsuarioDTO consultar(final Long id) {
        if(isNull(id)) {
            BadRequestException.throwNew("ID não pode ser nulo.");
        }
        Optional<UsuarioEntity> opUsuario = usuarioRepository.findById(id);

        UsuarioEntity usuario = opUsuario.<NotFoundException>orElseThrow(() -> {
            throw new NotFoundException("ID não corresponde a nenhum fornecedor.");
        });

        return usuarioMapper.map(usuario);
    }

}
