package br.edu.ifsp.bra.medsea.model;

import jakarta.persistence.*;

@Entity
public class Familiar extends Cadastro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Geração automática do ID
    private int id; // Chave primária da entidade

    private int cartaoSUSFamiliar;
    private int convenioFamiliar;

    @ManyToOne
    @JoinColumn(name = "paciente_id") // Relacionamento com Paciente
    private Paciente paciente;

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCartaoSUSFamiliar() {
        return cartaoSUSFamiliar;
    }

    public void setCartaoSUSFamiliar(int cartaoSUSFamiliar) {
        this.cartaoSUSFamiliar = cartaoSUSFamiliar;
    }

    public int getConvenioFamiliar() {
        return convenioFamiliar;
    }

    public void setConvenioFamiliar(int convenioFamiliar) {
        this.convenioFamiliar = convenioFamiliar;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
