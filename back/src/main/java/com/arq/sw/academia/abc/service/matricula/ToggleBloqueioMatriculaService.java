package com.arq.sw.academia.abc.service.matricula;

import com.arq.sw.academia.abc.entity.MatriculaEntity;
import com.arq.sw.academia.abc.exception.status.BadRequestException;
import com.arq.sw.academia.abc.exception.status.NotFoundException;
import com.arq.sw.academia.abc.repository.MatriculaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import static java.util.Optional.ofNullable;
import static org.apache.commons.lang3.StringUtils.isEmpty;

@Slf4j
@Service
public class ToggleBloqueioMatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    public void toogleBloqueio(final String cpf) {
        if(isEmpty(cpf)) {
            throw new BadRequestException("CPF não pode ser nulo");
        }

        final Optional<MatriculaEntity> opMatricula = ofNullable(matriculaRepository.findByUsuarioCpf(cpf));
        final MatriculaEntity matricula = opMatricula.<NotFoundException>orElseThrow(() -> {
            throw new NotFoundException("CPF não corresponde a nenhum usuário cadastrado.");
        });

        matricula.setBloqueada(!matricula.getBloqueada());
        matricula.setDataBloqueio(LocalDateTime.now());

        matriculaRepository.save(matricula);
    }


}
