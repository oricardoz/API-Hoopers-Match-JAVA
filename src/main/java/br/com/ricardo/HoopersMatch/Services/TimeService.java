package br.com.ricardo.HoopersMatch.Services;

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
        if (cadastroTimeDTO.getNome() == null || cadastroTimeDTO.getNome().trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nome do time é inválido.");
        }

        Time time = new Time();
        time.setNomeTime(cadastroTimeDTO.getNome());

        timeRepository.save(time);
    }
}
