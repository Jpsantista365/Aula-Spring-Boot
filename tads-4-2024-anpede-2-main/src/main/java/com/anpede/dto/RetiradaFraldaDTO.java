package com.anpede.dto;

import java.io.Serializable;
import java.util.Date;

import com.anpede.entities.RetiradaFralda;
import com.anpede.entities.Fralda;
import com.anpede.entities.Associado;

public class RetiradaFraldaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Integer quantidade;
    private Date dataRetirada;
    private Fralda fralda;
    private Associado associado;

    public RetiradaFraldaDTO() {
        // TODO Auto-generated constructor stub
    }

    public RetiradaFraldaDTO(Long id, Integer quantidade, Date dataRetirada, Fralda fralda, Associado associado) {
        this.id = id;
        this.quantidade = quantidade;
        this.dataRetirada = dataRetirada;
        this.fralda = fralda;
        this.associado = associado;
    }

    public RetiradaFraldaDTO(RetiradaFralda entity) {
        this.id = entity.getId();
        this.quantidade = entity.getQuantidade();
        this.dataRetirada = entity.getDataRetirada();
        this.fralda = entity.getFralda();
        this.associado = entity.getAssociado();
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

    public void setDataRetirada(Date dataRetirada) {
        this.dataRetirada = dataRetirada;
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
}
