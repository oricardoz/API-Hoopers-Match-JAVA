package br.com.ricardo.HoopersMatch.domain;

import br.com.ricardo.HoopersMatch.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "teams")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    // Um time pode ter muitos jogadores
    @OneToMany
    @JoinColumn(name = "team_id")  // O join column especifica a coluna no lado "muitos"
    private List<User> players;

    // Um time pode ter muitos jogos no histórico
    @OneToMany
    @JoinColumn(name = "team_id")
    private List<Games> games;

    // Um time pode ter muitos convites
    @OneToMany
    @JoinColumn(name = "team_id")
    private List<Invites> invites;
}
