/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.model.entities;

import java.util.Date;

/**
 *
 * @author jamilly
 */
public class Denuncia {
    private int codigo;
    private Date date;
    private String turno;
    private String descricaoOcorrido;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getDescricaoOcorrido() {
        return descricaoOcorrido;
    }

    public void setDescricaoOcorrido(String descricaoOcorrido) {
        this.descricaoOcorrido = descricaoOcorrido;
    }
}
