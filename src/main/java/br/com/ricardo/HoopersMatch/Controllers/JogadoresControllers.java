package br.com.ricardo.HoopersMatch.Controllers;


import br.com.ricardo.HoopersMatch.Repositories.TimeRepository;
import br.com.ricardo.HoopersMatch.Services.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jogadores")
public class JogadoresControllers {

    private final JogadorService jogadorService;

    @Autowired
    public JogadoresControllers(JogadorService jogadorService, TimeRepository timeRepository) {
        this.jogadorService = jogadorService;
    }
}
