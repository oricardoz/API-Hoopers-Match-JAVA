package br.com.ricardo.HoopersMatch.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "invites")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Invites {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String status;

    @ManyToOne
    @JoinColumn(name = "team_one_id")
    private Team teamOne;

    @ManyToOne
    @JoinColumn(name = "team_two_id")
    private Team teamTwo;
}
