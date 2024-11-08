package br.edu.ifsp.bra.medsea.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Arrays;

@Entity
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome_usuario", nullable = false)
    private String nomeUsuario;

    @Column(name = "bio_usuario", nullable = false)
    private String bioUsuario;

    @Column(name = "foto_usuario", nullable = true)
    private byte[] fotoUsuario;  

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getBioUsuario() {
        return bioUsuario;
    }

    public void setBioUsuario(String bioUsuario) {
        this.bioUsuario = bioUsuario;
    }

    public byte[] getFotoUsuario() {
        return fotoUsuario;
    }

    public void setFotoUsuario(byte[] fotoUsuario) {
        this.fotoUsuario = fotoUsuario;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Perfil{" +
                "id=" + id +
                ", nomeUsuario='" + nomeUsuario + '\'' +
                ", bioUsuario='" + bioUsuario + '\'' +
                ", fotoUsuario=" + Arrays.toString(fotoUsuario) +
                '}';
    }
}
