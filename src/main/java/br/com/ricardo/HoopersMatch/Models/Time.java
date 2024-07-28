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
    private String login;
    private String email;
    private String senha;
    @OneToMany(mappedBy = "time")
    private List<Jogador> jogadores;

    public Time(String nomeTime, String login, String email, String senha, List<Jogador> jogadores) {
        this.nomeTime = nomeTime;
        this.login = login;
        this.email = email;
        this.senha = senha;
        this.jogadores = jogadores;
    }

    public Time() {}

    public long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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
