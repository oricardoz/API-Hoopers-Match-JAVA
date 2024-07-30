package br.com.ricardo.HoopersMatch.Models.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginUsuarioDTO {

    private String login;
    private String senha;
}
