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
    private List<Jogadores> jogadores;

    public Time() {}

    public Time(String nomeTime, List<Jogadores> jogadores) {
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

    public List<Jogadores> getJogadores() {
        return jogadores;
    }

    public void setJogadores(List<Jogadores> jogadores) {
        this.jogadores = jogadores;
    }
}
