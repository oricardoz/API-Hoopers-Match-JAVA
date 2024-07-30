package br.com.ricardo.HoopersMatch.Services.Auth;

import br.com.ricardo.HoopersMatch.Models.Arbitro;
import br.com.ricardo.HoopersMatch.Models.DTO.LoginUsuarioDTO;
import br.com.ricardo.HoopersMatch.Models.Jogador;
import br.com.ricardo.HoopersMatch.Models.Time;
import br.com.ricardo.HoopersMatch.Repositories.ArbitroRepository;
import br.com.ricardo.HoopersMatch.Repositories.JogadorRepository;
import br.com.ricardo.HoopersMatch.Repositories.TimeRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final ArbitroRepository arbitroRepository;
    private final JogadorRepository jogadorRepository;
    private final TimeRepository timeRepository;

    public LoginService(ArbitroRepository arbitroRepository, JogadorRepository jogadorRepository, TimeRepository timeRepository) {
        this.arbitroRepository = arbitroRepository;
        this.jogadorRepository = jogadorRepository;
        this.timeRepository = timeRepository;
    }

    public void autenticarUsuario(LoginUsuarioDTO loginUsuarioDTO) {
        Jogador jogador = jogadorRepository.findByEmailAndSenha(loginUsuarioDTO.getLogin(), loginUsuarioDTO.getSenha());
        if(jogador == null) {
            Arbitro arbitro = arbitroRepository.findByEmailAndSenha(loginUsuarioDTO.getLogin(), loginUsuarioDTO.getSenha());
            if(arbitro == null) {
                Time time = timeRepository.findByEmailAndSenha(loginUsuarioDTO.getLogin(), loginUsuarioDTO.getSenha());
            }
        }
    }
}
