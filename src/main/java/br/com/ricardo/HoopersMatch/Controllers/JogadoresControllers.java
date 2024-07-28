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
    private final TimeRepository timeRepository;

    @Autowired
    public JogadoresControllers(JogadorService jogadorService, TimeRepository timeRepository) {
        this.jogadorService = jogadorService;
        this.timeRepository = timeRepository;
        this.time = Optional.of(new Time());
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarJogador(@RequestBody CadastroJogadorDTO cadastroJogadorDTO, IdTimeDTO idTimeDTO) {
        try {
            Optional<Time> time = timeRepository.findById(idTimeDTO.getId());
            if (time.isPresent()) {
                jogadorService.criarJogador(cadastroJogadorDTO, time.get());
                return new ResponseEntity<>("Jogador criado com sucesso!", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Time não encontrado", HttpStatus.NOT_FOUND);
            }
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        } catch (Exception e) {
            return new ResponseEntity<>("Erro inesperado ao criar o jogador: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
