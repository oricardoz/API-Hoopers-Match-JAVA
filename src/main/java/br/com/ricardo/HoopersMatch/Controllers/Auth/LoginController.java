package br.com.ricardo.HoopersMatch.Controllers.Auth;

import br.com.ricardo.HoopersMatch.Models.DTO.LoginUsuarioDTO;
import br.com.ricardo.HoopersMatch.Services.Auth.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody LoginUsuarioDTO loginUsuarioDTO) {
        loginService.autenticarUsuario(loginUsuarioDTO);
        return ResponseEntity.ok().body("Usuario autenticado com sucesso");
    }


}
