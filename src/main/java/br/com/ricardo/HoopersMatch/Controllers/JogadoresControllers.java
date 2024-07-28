package br.com.ricardo.HoopersMatch.Controllers;

import br.com.ricardo.HoopersMatch.Models.DTO.CadastroJogadorDTO;
import br.com.ricardo.HoopersMatch.Models.DTO.IdTimeDTO;
import br.com.ricardo.HoopersMatch.Models.Time;
import br.com.ricardo.HoopersMatch.Repositories.TimeRepository;
import br.com.ricardo.HoopersMatch.Services.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Controller
@RequestMapping("/jogadores")
public class JogadoresControllers {

    private final JogadorService jogadorService;
    private Optional<Time> time;

    @Autowired
    public JogadoresControllers(JogadorService jogadorService, TimeRepository timeRepository) {
        this.jogadorService = jogadorService;
    }
}
