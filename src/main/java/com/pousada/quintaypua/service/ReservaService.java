package com.pousada.quintaypua.service;

import com.pousada.quintaypua.domain.Acomodacao;
import com.pousada.quintaypua.domain.Hospede;
import com.pousada.quintaypua.domain.Reserva;
import com.pousada.quintaypua.exception.QuantidadeHospedesException;
import com.pousada.quintaypua.repository.AcomodacaoRepository;
import com.pousada.quintaypua.repository.HospedeRepository;
import com.pousada.quintaypua.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private AcomodacaoRepository acomodacaoRepository;

    public List<Reserva> getAll(){
        List<Reserva> result = new ArrayList<>();
        reservaRepository.findAll().forEach(result::add);
        return result;
    }

    public Optional<Reserva> getById(Long id){
        return reservaRepository.findById(id);
    }

    public Reserva createOrUpdate(Reserva reserva) {
        Optional<Acomodacao> acomodacao = acomodacaoRepository.findById(reserva.getIdAcomodacao());

        if(!acomodacao.isPresent()){
            throw new QuantidadeHospedesException("Não foi possível encontrar a acomodação.");
        }
        if(acomodacao.get().getQtdHospedes() < reserva.getQtdHospedes()){
            throw new QuantidadeHospedesException("A quantidade de hóspedes informada é superior ao número de vagas da acomodação.");
        }

        return reservaRepository.save(reserva);
    }

    public void delete(Long id) {
        reservaRepository.deleteById(id);
    }
}