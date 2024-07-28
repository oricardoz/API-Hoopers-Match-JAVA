package br.com.ricardo.HoopersMatch.Models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "PARTIDA")
public class Partida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "arbitro_id")
    private Arbitro arbitro;
    @ManyToOne
    @JoinColumn(name = "time1_id")
    private Time time1;
    @ManyToOne
    @JoinColumn(name = "time2_id")
    private Time time2;
    private int pontuacaoTime1;
    private int pontuacaoTime2;
    private Date dataPartida;

    public Partida(Arbitro arbitro, Time time1, Time time2, int pontuacaoTime1, int pontuacaoTime2, Date dataPartida) {
        this.arbitro = arbitro;
        this.time1 = time1;
        this.time2 = time2;
        this.pontuacaoTime1 = pontuacaoTime1;
        this.pontuacaoTime2 = pontuacaoTime2;
        this.dataPartida = dataPartida;
    }

    public Partida() {}

    public long getId() {
        return id;
    }

    public Arbitro getArbitro() {
        return arbitro;
    }

    public void setArbitro(Arbitro arbitro) {
        this.arbitro = arbitro;
    }

    public Time getTime1() {
        return time1;
    }

    public void setTime1(Time time1) {
        this.time1 = time1;
    }

    public Time getTime2() {
        return time2;
    }

    public void setTime2(Time time2) {
        this.time2 = time2;
    }

    public int getPontuacaoTime1() {
        return pontuacaoTime1;
    }

    public void setPontuacaoTime1(int pontuacaoTime1) {
        this.pontuacaoTime1 = pontuacaoTime1;
    }

    public int getPontuacaoTime2() {
        return pontuacaoTime2;
    }

    public void setPontuacaoTime2(int pontuacaoTime2) {
        this.pontuacaoTime2 = pontuacaoTime2;
    }

    public Date getDataPartida() {
        return dataPartida;
    }

    public void setDataPartida(Date dataPartida) {
        this.dataPartida = dataPartida;
    }
}
