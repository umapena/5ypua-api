package com.pousada.quintaypua.service;

import com.pousada.quintaypua.domain.Acomodacao;
import com.pousada.quintaypua.repository.AcomodacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AcomodacaoService {
    @Autowired
    private AcomodacaoRepository acomodacaoRepository;

    public List<Acomodacao> getAll(){
        List<Acomodacao> result = new ArrayList<>();
        acomodacaoRepository.findAll().forEach(result::add);
        return result;
    }

    public Optional<Acomodacao> getById(Long id){
        return acomodacaoRepository.findById(id);
    }

    public Acomodacao createOrUpdate(Acomodacao hospede) {
        return acomodacaoRepository.save(hospede);
    }

    public void delete(Long id) {
        acomodacaoRepository.deleteById(id);
    }
}