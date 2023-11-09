package com.pousada.quintaypua.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Acomodacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String numero;

    @Column(name = "valor_diaria")
    Float valorDiaria;

    @Column(name= "qtd_hospedes")
    Long qtdHospedes;

    public Acomodacao() {
    }

    public Acomodacao(Long id, String numero, Float valorDiaria, Long qtdHospedes) {
        this.id = id;
        this.numero = numero;
        this.valorDiaria = valorDiaria;
        this.qtdHospedes = qtdHospedes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Float getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(Float valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public Long getQtdHospedes() {
        return qtdHospedes;
    }

    public void setQtdHospedes(Long qtdHospedes) {
        this.qtdHospedes = qtdHospedes;
    }
}
