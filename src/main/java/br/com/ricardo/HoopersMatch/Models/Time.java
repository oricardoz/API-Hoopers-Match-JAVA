package br.com.ricardo.HoopersMatch.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "TIME")
public class Time {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nomeTime;
    @OneToMany(mappedBy = "time")
    private List<Jogador> jogadores;

    public Time() {}

    public Time(String nomeTime, List<Jogador> jogadores) {
        this.nomeTime = nomeTime;
        this.jogadores = jogadores;
    }

    public long getId() {
        return id;
    }

    public String getNomeTime() {
        return nomeTime;
    }

    public void setNomeTime(String nomeTime) {
        this.nomeTime = nomeTime;
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(List<Jogador> jogadores) {
        this.jogadores = jogadores;
    }
}
