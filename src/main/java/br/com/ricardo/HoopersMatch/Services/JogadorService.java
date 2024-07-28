package br.com.ricardo.HoopersMatch.Services;

import br.com.ricardo.HoopersMatch.Models.DTO.JogadorDTO;
import br.com.ricardo.HoopersMatch.Models.DTO.JogadorTimeDTO;
import br.com.ricardo.HoopersMatch.Models.Jogador;
import br.com.ricardo.HoopersMatch.Models.Time;
import br.com.ricardo.HoopersMatch.Repositories.JogadorRepository;
import br.com.ricardo.HoopersMatch.Repositories.TimeRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JogadorService {

    @Autowired
    public JogadorRepository jogadoresRepository;

    @Autowired
    public TimeRepository timeRepository;

    public void criarJogador(JogadorTimeDTO jogadorTimeDTO, JogadorDTO jogadorDTO) {
        Jogador jogador = new Jogador();

        jogador.setCpf(jogadorDTO.getCpf());
        jogador.setNome(jogadorDTO.getNome());
        jogador.setDataNascimento(jogadorDTO.getDataNascimento());
        jogador.setTime(timeRepository.findByNomeTime(jogadorTimeDTO.getNomeTime()));

        jogadoresRepository.save(jogador);
    }
}
