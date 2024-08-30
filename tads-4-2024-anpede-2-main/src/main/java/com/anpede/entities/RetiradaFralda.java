package com.anpede.entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class RetiradaFralda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantidade;
    private Date dataRetirada;

    @ManyToOne
    @JoinColumn(name = "fralda_id")
    private Fralda fralda;

    @ManyToOne
    @JoinColumn(name = "associado_id")
    private Associado associado;

    public RetiradaFralda() {}

    public RetiradaFralda(Integer quantidade, Date dataRetirada, Fralda fralda, Associado associado) {
        this.quantidade = quantidade;
        this.dataRetirada = dataRetirada;
        this.fralda = fralda;
        this.associado = associado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Date getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(java.util.Date date) {
        this.dataRetirada = (Date) date;
    }

    public Fralda getFralda() {
        return fralda;
    }

    public void setFralda(Fralda fralda) {
        this.fralda = fralda;
    }

    public Associado getAssociado() {
        return associado;
    }

    public void setAssociado(Associado associado) {
        this.associado = associado;
    }

    @Override
    public String toString() {
        return "RetiradaFralda{" + "id=" + id + ", quantidade=" + quantidade + ", dataRetirada=" + dataRetirada +
                ", fralda=" + fralda + ", associado=" + associado + '}';
    }
}
