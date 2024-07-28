package br.com.ricardo.HoopersMatch.Services;

import br.com.ricardo.HoopersMatch.Models.DTO.CadastroJogadorDTO;
import br.com.ricardo.HoopersMatch.Models.Jogador;
import br.com.ricardo.HoopersMatch.Models.Time;
import br.com.ricardo.HoopersMatch.Repositories.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class JogadorService {

    private final JogadorRepository jogadorRepository;

    @Autowired
    public JogadorService(JogadorRepository jogadorRepository) {
        this.jogadorRepository = jogadorRepository;
    }

    public void criarJogador(CadastroJogadorDTO jogadorDTO) {
        if (!validarDadosCadastroJogador(jogadorDTO)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválidos para cadastro do jogador.");
        }

        Jogador jogador = new Jogador();
        jogador.setEmail(jogador.getEmail());
        jogador.setSenha(jogadorDTO.getSenha());
        jogador.setLogin(jogadorDTO.getLogin());
        jogador.setCpf(jogadorDTO.getCpf());
        jogador.setNome(jogadorDTO.getNome());
        jogador.setDataNascimento(jogadorDTO.getDataNascimento());

        jogadorRepository.save(jogador);
    }

    private boolean validarDadosCadastroJogador(CadastroJogadorDTO jogadorDTO) {
        if (jogadorDTO.getNome() == null || jogadorDTO.getNome().trim().isEmpty()) {
            return false;
        }
        if (jogadorDTO.getCpf() == null || jogadorDTO.getCpf().trim().isEmpty()) {
            return false;
        }
        if (jogadorDTO.getEmail() == null || jogadorDTO.getEmail().trim().isEmpty()) {
            return false;
        }
        if (jogadorDTO.getLogin() == null || jogadorDTO.getLogin().trim().isEmpty()) {
            return false;
        }
        if (jogadorDTO.getSenha() == null || jogadorDTO.getSenha().trim().isEmpty()) {
            return false;
        }
        if (jogadorDTO.getDataNascimento() == null) {
            return false;
        }

        return true;
    }
}
