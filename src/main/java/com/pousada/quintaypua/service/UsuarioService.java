package com.pousada.quintaypua.service;

import com.pousada.quintaypua.domain.Reserva;
import com.pousada.quintaypua.domain.Usuario;
import com.pousada.quintaypua.repository.ReservaRepository;
import com.pousada.quintaypua.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getAll(){
        List<Usuario> result = new ArrayList<>();
        usuarioRepository.findAll().forEach(result::add);
        return result;
    }

    public Optional<Usuario> getById(Long id){
        return usuarioRepository.findById(id);
    }

    public Usuario createOrUpdate(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }
}