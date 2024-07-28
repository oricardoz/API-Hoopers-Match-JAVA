package br.com.ricardo.HoopersMatch.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "ARBITRO")
public class Arbitro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String numeroContato;

    public Arbitro(String nome, String numeroContato) {
        this.nome = nome;
        this.numeroContato = numeroContato;
    }

    public Arbitro() {}

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumeroContato() {
        return numeroContato;
    }

    public void setNumeroContato(String numeroContato) {
        this.numeroContato = numeroContato;
    }
}
