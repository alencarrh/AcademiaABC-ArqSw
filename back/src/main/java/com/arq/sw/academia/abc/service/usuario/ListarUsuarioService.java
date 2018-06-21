package com.arq.sw.academia.abc.service.usuario;

import com.arq.sw.academia.abc.dto.UsuarioDTO;
import com.arq.sw.academia.abc.entity.UsuarioEntity;
import com.arq.sw.academia.abc.mapper.dto.UsuarioDTOMapper;
import com.arq.sw.academia.abc.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Service
public class ListarUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioDTOMapper usuarioMapper;


    public List<UsuarioDTO> listar() {
        List<UsuarioEntity> usuarios = newArrayList(usuarioRepository.findAll());
        return usuarioMapper.map(usuarios);
    }

}
