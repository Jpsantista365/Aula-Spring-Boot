package com.anpede.dto;

import java.io.Serializable;
import java.util.Date;

import com.anpede.entities.Emprestimo;
import com.anpede.entities.Equipamento;
import com.anpede.entities.Associado;

public class EmprestimoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Date dataRetirada;
    private Date dataDevolucao;
    private String motivo;
    private Equipamento equipamento;
    private Associado associado;

    public EmprestimoDTO() {
        // TODO Auto-generated constructor stub
    }

    public EmprestimoDTO(Long id, Date dataRetirada, Date dataDevolucao, String motivo, Equipamento equipamento, Associado associado) {
        this.id = id;
        this.dataRetirada = dataRetirada;
        this.dataDevolucao = dataDevolucao;
        this.motivo = motivo;
        this.equipamento = equipamento;
        this.associado = associado;
    }

    public EmprestimoDTO(Emprestimo entity) {
        this.id = entity.getId();
        this.dataRetirada = entity.getDataRetirada();
        this.dataDevolucao = entity.getDataDevolucao();
        this.motivo = entity.getMotivo();
        this.equipamento = entity.getEquipamento();
        this.associado = entity.getAssociado();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(Date dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public Associado getAssociado() {
        return associado;
    }

    public void setAssociado(Associado associado) {
        this.associado = associado;
    }
}