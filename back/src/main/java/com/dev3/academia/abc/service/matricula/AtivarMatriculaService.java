package com.dev3.academia.abc.service.matricula;

import com.dev3.academia.abc.dto.MatriculaDTO;
import com.dev3.academia.abc.entity.MatriculaEntity;
import com.dev3.academia.abc.entity.UsuarioEntity;
import com.dev3.academia.abc.exception.status.BadRequestException;
import com.dev3.academia.abc.exception.status.NotFoundException;
import com.dev3.academia.abc.mapper.dto.MatriculaDTOMapper;
import com.dev3.academia.abc.repository.MatriculaRepository;
import com.dev3.academia.abc.repository.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.dev3.academia.abc.entity.MatriculaEntity.newMatricula;
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
            throw new BadRequestException("CPF é obrigatório e não pode ser nulo.");
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
