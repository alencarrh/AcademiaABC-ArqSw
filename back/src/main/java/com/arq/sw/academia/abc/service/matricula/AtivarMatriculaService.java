package com.arq.sw.academia.abc.service.matricula;

import com.arq.sw.academia.abc.dto.MatriculaDTO;
import com.arq.sw.academia.abc.entity.MatriculaEntity;
import com.arq.sw.academia.abc.entity.UsuarioEntity;
import com.arq.sw.academia.abc.exception.status.BadRequestException;
import com.arq.sw.academia.abc.exception.status.NotFoundException;
import com.arq.sw.academia.abc.mapper.dto.MatriculaDTOMapper;
import com.arq.sw.academia.abc.repository.MatriculaRepository;
import com.arq.sw.academia.abc.repository.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.arq.sw.academia.abc.entity.MatriculaEntity.newMatricula;
import static java.util.Optional.ofNullable;
import static org.apache.commons.lang3.StringUtils.isEmpty;

@Slf4j
@Service
public class AtivarMatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private MatriculaDTOMapper mapper;

    public MatriculaDTO ativar(final String cpf) {
        if(isEmpty(cpf)) {
            BadRequestException.throwNew("CPF é obrigatório e não pode ser nulo.");
        }

        final Optional<UsuarioEntity> optionalUsuario = ofNullable(usuarioRepository.findByCpf(cpf));

        final UsuarioEntity usuario = optionalUsuario.<NotFoundException>orElseThrow(() -> {
            throw new NotFoundException("CPF não corresponde a nenhum usuário cadastrado.");
        });

        MatriculaEntity matricula = newMatricula(usuario);
        matricula = matriculaRepository.save(matricula);

        return mapper.map(matricula);
    }

}
