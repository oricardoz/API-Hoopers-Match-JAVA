package br.com.ricardo.HoopersMatch.Controllers.Auth;

import br.com.ricardo.HoopersMatch.Models.Arbitro;
import br.com.ricardo.HoopersMatch.Models.DTO.CadastroArbitroDTO;
import br.com.ricardo.HoopersMatch.Models.DTO.CadastroJogadorDTO;
import br.com.ricardo.HoopersMatch.Models.DTO.CadastroTimeDTO;
import br.com.ricardo.HoopersMatch.Services.ArbitroService;
import br.com.ricardo.HoopersMatch.Services.JogadorService;
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
@RequestMapping("/registrar")
public class RegisterController {

    private final JogadorService jogadorService;
    private final TimeService timeService;
    private final ArbitroService arbitroService;

    @Autowired
    public RegisterController(JogadorService jogadorService, TimeService timeService, ArbitroService arbitroService) {
        this.jogadorService = jogadorService;
        this.timeService = timeService;
        this.arbitroService = arbitroService;
    }

    @PostMapping("/jogador")
    public ResponseEntity<String> registrarJogador(@RequestBody CadastroJogadorDTO cadastroJogadorDTO) {

        try {
            jogadorService.criarJogador(cadastroJogadorDTO);
            return new ResponseEntity<>("Jogador criado com êxito", HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }catch (Exception e) {
            return new ResponseEntity<>("Erro inesperado ao criar o jogador: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/time")
    public ResponseEntity<String> registrarTime(@RequestBody CadastroTimeDTO cadastroTimeDTO) {
        try {
            timeService.criarTime(cadastroTimeDTO);
            return new ResponseEntity<>("Time criado com êxito", HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(),e.getStatusCode());
        } catch (Exception e) {
            return new ResponseEntity<>("Erro inesperado ao criar o jogador: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/arbitro")
    public ResponseEntity<String> registrarArbitro(@RequestBody CadastroArbitroDTO cadastroArbitroDTO) {
        try {
            arbitroService.criarArbitro(cadastroArbitroDTO);
            return new ResponseEntity<>("Arbitro criado com êxito", HttpStatus.OK);
        } catch (ResponseStatusException e){
            return new ResponseEntity<>(e.getReason(),e.getStatusCode());
        } catch (Exception e) {
            return new ResponseEntity<>("Erro inesperado ao criar o arbitro: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
