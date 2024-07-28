package br.com.ricardo.HoopersMatch.Controllers;

import br.com.ricardo.HoopersMatch.Models.DTO.CadastroTimeDTO;
import br.com.ricardo.HoopersMatch.Services.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequestMapping("/time")
public class TimeController {

    private final TimeService timeService;

    @Autowired
    public TimeController(TimeService timeService) {
        this.timeService = timeService;
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarTime(@RequestBody CadastroTimeDTO cadastroTimeDTO) {
        try {
            timeService.criarTime(cadastroTimeDTO);
            return new ResponseEntity<>("Time criado com sucesso!", HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Erro inesperado ao criar o time: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
