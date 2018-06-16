package com.arq.sw.academia.abc.service.matricula;

import com.arq.sw.academia.abc.dto.MatriculaDTO;
import com.arq.sw.academia.abc.dto.request.matricula.CadastrarMatriculaRequest;
import com.arq.sw.academia.abc.entity.MatriculaEntity;
import com.arq.sw.academia.abc.entity.UsuarioEntity;
import com.arq.sw.academia.abc.exception.status.BadRequestException;
import com.arq.sw.academia.abc.mapper.dto.MatriculaDTOMapper;
import com.arq.sw.academia.abc.repository.MatriculaRepository;
import com.arq.sw.academia.abc.repository.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

import static com.arq.sw.academia.abc.entity.MatriculaEntity.newMatricula;
import static java.util.Objects.isNull;
import static java.util.Optional.ofNullable;
import static org.springframework.util.StringUtils.isEmpty;

@Slf4j
@Service
public class CadastrarMatriculaService {

    @Autowired
    private AtivarMatriculaService ativarMatriculaService;

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private MatriculaDTOMapper mapper;

    public MatriculaDTO cadastrar(CadastrarMatriculaRequest request) {
        validar(request);

        if(usuarioExiste(request.getCpf())) {
            return ativarMatriculaService.ativar(request.getCpf());
        }

        UsuarioEntity usuario = UsuarioEntity.builder()
                                             .nome(request.getNome())
                                             .cpf(request.getCpf())
                                             .dataNascimento(request.getDataNascimento())
                                             .build();

        usuario = usuarioRepository.save(usuario);

        MatriculaEntity matricula = newMatricula(usuario);
        matricula = matriculaRepository.save(matricula);

        return mapper.map(matricula);
    }

    private boolean usuarioExiste(String cpf) {
        final Optional<UsuarioEntity> optionalUsuario = ofNullable(usuarioRepository.findByCpf(cpf));
        return optionalUsuario.isPresent();
    }

    private void validar(CadastrarMatriculaRequest request) {
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
