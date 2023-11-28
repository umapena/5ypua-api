package com.pousada.quintaypua.domain;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="id_funcionario")
    private Long idFuncionario;

    @Column(name="id_hospede")
    private Long idHospede;

    @Column(name="id_acomodacao")
    private Long idAcomodacao;

    @Column(name="dt_inicial")
    private Date dataInicial;

    @Column(name="qtd_diarias")
    private Long qtdDiarais;

    @Column(name="status_pagamento")
    private String statusPagamento;

    @Column(name="dt_checkin")
    private Date dataCheckIn;

    @Column(name="dt_checkout")
    private Date dataCheckOut;

    public Reserva() {
    }

    public Reserva(Long id, Long idFuncionario, Long idHospede, Long idAcomodacao, Date dataInicial, Long qtdDiarais, String statusPagamento, Date dataCheckIn, Date dataCheckOut) {
        this.id = id;
        this.idFuncionario = idFuncionario;
        this.idAcomodacao = idAcomodacao;
        this.idHospede = idHospede;
        this.dataInicial = dataInicial;
        this.qtdDiarais = qtdDiarais;
        this.statusPagamento = statusPagamento;
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Long idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Long getIdHospede() {
        return idHospede;
    }

    public void setIdHospede(Long idHospede) {
        this.idHospede = idHospede;
    }

    public Long getIdAcomodacao() {
        return idAcomodacao;
    }

    public void setIdAcomodacao(Long idAcomodacao) {
        this.idAcomodacao = idAcomodacao;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Long getQtdDiarais() {
        return qtdDiarais;
    }

    public void setQtdDiarais(Long qtdDiarais) {
        this.qtdDiarais = qtdDiarais;
    }

    public String getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(String statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    public Date getDataCheckIn() {
        return dataCheckIn;
    }

    public void setDataCheckIn(Date dataCheckIn) {
        this.dataCheckIn = dataCheckIn;
    }

    public Date getDataCheckOut() {
        return dataCheckOut;
    }

    public void setDataCheckOut(Date dataCheckOut) {
        this.dataCheckOut = dataCheckOut;
    }
}
