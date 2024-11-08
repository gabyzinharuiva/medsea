package br.edu.ifsp.bra.medsea.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pacientes")
public class Paciente extends Cadastro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    private String cpf;
    private String endereco;
    private String cartaoSUSPaciente;
    private String convenioPaciente;

    // Construtor padrão (sem parâmetros)
    public Paciente() {
    }

    // Construtor com parâmetros, se necessário
    public Paciente(String nome, String cpf, String endereco, String cartaoSUSPaciente, String convenioPaciente) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.cartaoSUSPaciente = cartaoSUSPaciente;
        this.convenioPaciente = convenioPaciente;
    }

    // Getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCartaoSUSPaciente() {
        return cartaoSUSPaciente;
    }

    public void setCartaoSUSPaciente(String cartaoSUSPaciente) {
        this.cartaoSUSPaciente = cartaoSUSPaciente;
    }

    public String getConvenioPaciente() {
        return convenioPaciente;
    }

    public void setConvenioPaciente(String convenioPaciente) {
        this.convenioPaciente = convenioPaciente;
    }
}
