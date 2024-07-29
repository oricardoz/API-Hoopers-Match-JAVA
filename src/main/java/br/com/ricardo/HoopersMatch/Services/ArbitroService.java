package br.com.ricardo.HoopersMatch.Services;

import br.com.ricardo.HoopersMatch.Models.Arbitro;
import br.com.ricardo.HoopersMatch.Models.DTO.CadastroArbitroDTO;
import br.com.ricardo.HoopersMatch.Models.DTO.CadastroTimeDTO;
import br.com.ricardo.HoopersMatch.Repositories.ArbitroRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ArbitroService {

    public final ArbitroRepository arbitroRepository;

    public ArbitroService(ArbitroRepository arbitroRepository) {
        this.arbitroRepository = arbitroRepository;
    }

    public void criarArbitro(CadastroArbitroDTO cadastroArbitroDTO) {
        if(!validarDadosCadastroTime(cadastroArbitroDTO)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválidos para cadastro do arbitro.");
        }

        Arbitro arbitro = new Arbitro();
        arbitro.setNome(cadastroArbitroDTO.getNome());
        arbitro.setNumeroContato(cadastroArbitroDTO.getNumeroContato());

        arbitroRepository.save(arbitro);

    }

    private boolean validarDadosCadastroTime(CadastroArbitroDTO cadastroArbitroDTO) {
        if (cadastroArbitroDTO.getNome() == null || cadastroArbitroDTO.getNome().trim().isEmpty()) {
            return false;
        }
        if (cadastroArbitroDTO.getNumeroContato() == null || cadastroArbitroDTO.getNumeroContato().trim().isEmpty()) {
            return false;
        }
        return true;
    }
}
