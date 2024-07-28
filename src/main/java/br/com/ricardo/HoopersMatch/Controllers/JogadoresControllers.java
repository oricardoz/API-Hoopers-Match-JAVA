package br.com.ricardo.HoopersMatch.Controllers;

import br.com.ricardo.HoopersMatch.Models.DTO.JogadorDTO;
import br.com.ricardo.HoopersMatch.Models.DTO.JogadorTimeDTO;
import br.com.ricardo.HoopersMatch.Services.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jogadores")
public class JogadoresControllers {

    @Autowired
    JogadorService jogadorService;

    @PostMapping("/criar")
    public void criarJogagor(@RequestBody JogadorDTO jogadorDTO, JogadorTimeDTO jogadorTimeDTO) {
        jogadorService.criarJogador(jogadorTimeDTO, jogadorDTO);
    };
}
