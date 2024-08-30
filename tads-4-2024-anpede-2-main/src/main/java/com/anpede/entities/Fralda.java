package com.anpede.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Fralda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    private Integer quantidadePacote;
    private String tamanho;
    private String genero;
    private String incontinencia;
    private String periodo;

    public Fralda() {}

    public Fralda(String descricao, Integer quantidadePacote, String tamanho, String genero, String incontinencia, String periodo) {
        this.descricao = descricao;
        this.quantidadePacote = quantidadePacote;
        this.tamanho = tamanho;
        this.genero = genero;
        this.incontinencia = incontinencia;
        this.periodo = periodo;
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

    @Override
    public String toString() {
        return "Fralda{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", quantidadePacote=" + quantidadePacote +
                ", tamanho='" + tamanho + '\'' +
                ", genero='" + genero + '\'' +
                ", incontinencia='" + incontinencia + '\'' +
                ", periodo='" + periodo + '\'' +
                '}';
    }
}