package br.com.ricardo.HoopersMatch.Models.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CadastroPartidaDTO {

    public String nomeTime1;
    public String nomeTime2;
    public String nomeArbitro;
    public int pontuacaoTime1;
    public int pontuacaoTime2;

}
