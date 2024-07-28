package br.com.ricardo.HoopersMatch.Services;

import br.com.ricardo.HoopersMatch.Models.DTO.CadastroJogadorDTO;
import br.com.ricardo.HoopersMatch.Models.DTO.CadastroTimeDTO;
import br.com.ricardo.HoopersMatch.Models.Time;
import br.com.ricardo.HoopersMatch.Repositories.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TimeService {

    private final TimeRepository timeRepository;

    @Autowired
    public TimeService(TimeRepository timeRepository) {
        this.timeRepository = timeRepository;
    }

    public void criarTime(CadastroTimeDTO cadastroTimeDTO) {
        if(!validarDadosCadastroTime(cadastroTimeDTO)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválidos para cadastro do jogador.");
        }

        Time time = new Time();
        time.setEmail(cadastroTimeDTO.getEmail());
        time.setLogin(cadastroTimeDTO.getLogin());
        time.setSenha(cadastroTimeDTO.getSenha());
        time.setNomeTime(cadastroTimeDTO.getNome());

        timeRepository.save(time);
    }

    private boolean validarDadosCadastroTime(CadastroTimeDTO cadastroTimeDTO) {
        if (cadastroTimeDTO.getNome() == null || cadastroTimeDTO.getNome().trim().isEmpty()) {
            return false;
        }
        if (cadastroTimeDTO.getEmail() == null || cadastroTimeDTO.getEmail().trim().isEmpty()) {
            return false;
        }
        if (cadastroTimeDTO.getLogin() == null || cadastroTimeDTO.getLogin().trim().isEmpty()) {
            return false;
        }
        if (cadastroTimeDTO.getSenha() == null || cadastroTimeDTO.getSenha().trim().isEmpty()) {
            return false;
        }

        return true;
    }
}
