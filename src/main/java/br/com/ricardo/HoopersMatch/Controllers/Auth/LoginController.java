package br.com.ricardo.HoopersMatch.Controllers.Auth;

import br.com.ricardo.HoopersMatch.Models.DTO.LoginUsuarioDTO;
import br.com.ricardo.HoopersMatch.Services.Auth.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody LoginUsuarioDTO loginUsuarioDTO) {
        String email = loginUsuarioDTO.getLogin();
        String senha = loginUsuarioDTO.getSenha();
        if (email == null || email.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("O email não pode estar em branco");
        }

        if (!email.contains("@") || !email.contains(".")) {
            return ResponseEntity.badRequest().body("O email deve ser válido");
        }

        if (senha == null || senha.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("A senha não pode estar em branco");
        }

        loginService.autenticarUsuario(loginUsuarioDTO);
        return ResponseEntity.ok().body("Usuario autenticado com sucesso");
    }
}
