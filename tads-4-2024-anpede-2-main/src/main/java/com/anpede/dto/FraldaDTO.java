package com.anpede.dto;

import java.io.Serializable;

import com.anpede.entities.Fralda;

public class FraldaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String descricao;
    private Integer quantidadePacote;
    private String tamanho;
    private String genero;
    private String incontinencia;
    private String periodo;

    public FraldaDTO() {}

    public FraldaDTO(Long id, String descricao, Integer quantidadePacote, String tamanho, String genero, String incontinencia, String periodo) {
        this.id = id;
        this.descricao = descricao;
        this.quantidadePacote = quantidadePacote;
        this.tamanho = tamanho;
        this.genero = genero;
        this.incontinencia = incontinencia;
        this.periodo = periodo;
    }

    public FraldaDTO(Fralda entity) {
        this.id = entity.getId();
        this.descricao = entity.getDescricao();
        this.quantidadePacote = entity.getQuantidadePacote();
        this.tamanho = entity.getTamanho();
        this.genero = entity.getGenero();
        this.incontinencia = entity.getIncontinencia();
        this.periodo = entity.getPeriodo();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getQuantidadePacote() {
        return quantidadePacote;
    }

    public void setQuantidadePacote(Integer quantidadePacote) {
        this.quantidadePacote = quantidadePacote;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getIncontinencia() {
        return incontinencia;
    }

    public void setIncontinencia(String incontinencia) {
        this.incontinencia = incontinencia;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
}