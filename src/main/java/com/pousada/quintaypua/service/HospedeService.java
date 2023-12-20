package com.pousada.quintaypua.service;

import com.pousada.quintaypua.domain.Acomodacao;
import com.pousada.quintaypua.domain.Hospede;
import com.pousada.quintaypua.repository.AcomodacaoRepository;
import com.pousada.quintaypua.repository.HospedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HospedeService {
    @Autowired
    private HospedeRepository hospedeRepository;

    public List<Hospede> getAll(){
        List<Hospede> result = new ArrayList<>();
        hospedeRepository.findAll().forEach(result::add);
        return result;
    }

    public Optional<Hospede> getById(Long id){
        return hospedeRepository.findById(id);
    }

    public Hospede createOrUpdate(Hospede hospede) {
        return hospedeRepository.save(hospede);
    }

    public void delete(Long id) {
        hospedeRepository.deleteById(id);
    }
}