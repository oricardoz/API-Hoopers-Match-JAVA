package br.com.ricardo.HoopersMatch.Controllers;

import br.com.ricardo.HoopersMatch.Models.DTO.CadastroPartidaDTO;
import br.com.ricardo.HoopersMatch.Services.PartidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequestMapping("/partida")
public class PartidaControllers {

    private final PartidaService partidaService;

    @Autowired
    public PartidaControllers(PartidaService partidaService) {
        this.partidaService = partidaService;
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarPartida(@RequestBody CadastroPartidaDTO criacaoPartidaDTO) {
        try {
            partidaService.criarPartida(criacaoPartidaDTO);
            return new ResponseEntity<>("Partida criada com sucesso", HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        } catch (Exception e) {
            return new ResponseEntity<>("Erro inesperado ao criar a partida: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
