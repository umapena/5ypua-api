package com.pousada.quintaypua.service;

import com.pousada.quintaypua.domain.Funcionario;
import com.pousada.quintaypua.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<Funcionario> getAll(){
        List<Funcionario> result = new ArrayList<>();
        funcionarioRepository.findAll().forEach(result::add);
        return result;
    }

    public Optional<Funcionario> getById(Long id){
        return funcionarioRepository.findById(id);
    }

    public Funcionario createOrUpdate(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public void delete(Long id) {
        funcionarioRepository.deleteById(id);
    }
}