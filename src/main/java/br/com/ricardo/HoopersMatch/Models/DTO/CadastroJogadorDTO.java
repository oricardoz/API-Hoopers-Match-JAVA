package br.com.ricardo.HoopersMatch.Models.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CadastroJogadorDTO {

    private String nome;
    private String login;
    private String senha;
    private String email;
    private String cpf;
    private Date dataNascimento;

}
