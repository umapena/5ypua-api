package com.pousada.quintaypua.repository;

import com.pousada.quintaypua.domain.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
}