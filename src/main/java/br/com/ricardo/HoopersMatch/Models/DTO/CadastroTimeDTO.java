package br.com.ricardo.HoopersMatch.Models.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CadastroTimeDTO {

    public String email;
    public String login;
    public String senha;
    public String nome;

}
