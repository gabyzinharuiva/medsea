package br.edu.ifsp.bra.medsea.model;

import jakarta.persistence.Id;

public class Depoimento {
    @Id
    private int id;
    private String tituloDepoimento;
    private String conteudoDepoimento;
    private int usuarioId;

    public Depoimento(int id, String tituloDepoimento, String conteudoDepoimento, int usuarioId) {
        this.id = id;
        this.tituloDepoimento = tituloDepoimento;
        this.conteudoDepoimento = conteudoDepoimento;
        this.usuarioId = usuarioId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTituloDepoimento() {
        return tituloDepoimento;  // O método correto aqui é getTituloDepoimento()
    }

    public void setTituloDepoimento(String tituloDepoimento) {
        this.tituloDepoimento = tituloDepoimento;
    }

    public String getConteudoDepoimento() {
        return conteudoDepoimento;
    }

    public void setConteudoDepoimento(String conteudoDepoimento) {
        this.conteudoDepoimento = conteudoDepoimento;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }
}
