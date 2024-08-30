package com.anpede.entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dataRetirada;
    private Date dataDevolucao;
    private String motivo;
    
    public Emprestimo() {}

    public Emprestimo(Date dataRetirada, Date dataDevolucao, String motivo, Equipamento equipamento, Associado associado) {
        this.dataRetirada = dataRetirada;
        this.dataDevolucao = dataDevolucao;
        this.motivo = motivo;
        this.equipamento = equipamento;
        this.associado = associado;
    }

    @ManyToOne
    private Equipamento equipamento;

    @ManyToOne
    private Associado associado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(java.util.Date date) {
        this.dataRetirada = (Date) date;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(java.util.Date date) {
        this.dataDevolucao = (Date) date;
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

    @Override
    public String toString() {
        return "Emprestimo{" + "id=" + id + ", dataRetirada=" + dataRetirada + ", dataDevolucao=" + dataDevolucao +
                ", motivo='" + motivo + '\'' + ", equipamento=" + equipamento + ", associado=" + associado + '}';
    }
    
}
