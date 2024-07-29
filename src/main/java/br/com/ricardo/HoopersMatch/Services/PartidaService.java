package br.com.ricardo.HoopersMatch.Services;

import br.com.ricardo.HoopersMatch.Models.Arbitro;
import br.com.ricardo.HoopersMatch.Models.DTO.CadastroPartidaDTO;
import br.com.ricardo.HoopersMatch.Models.Partida;
import br.com.ricardo.HoopersMatch.Models.Time;
import br.com.ricardo.HoopersMatch.Repositories.ArbitroRepository;
import br.com.ricardo.HoopersMatch.Repositories.PartidaRepository;
import br.com.ricardo.HoopersMatch.Repositories.TimeRepository;
import org.springframework.stereotype.Service;

@Service
public class PartidaService {

    private final PartidaRepository partidaRepository;
    private final ArbitroRepository arbitroRepository;
    private final TimeRepository timeRepository;

    public PartidaService(PartidaRepository partidaRepository, ArbitroRepository arbitroRepository, TimeRepository timeRepository) {
        this.partidaRepository = partidaRepository;
        this.arbitroRepository = arbitroRepository;
        this.timeRepository = timeRepository;
    }

    public void criarPartida(CadastroPartidaDTO cadastroPartidaDTO) {
        Partida partida = new Partida();

        partida.setArbitro(arbitroRepository.findArbitroByNome(cadastroPartidaDTO.getNomeArbitro()));
        partida.setTime1(timeRepository.findByNomeTime(cadastroPartidaDTO.getNomeTime1()));
        partida.setTime2(timeRepository.findByNomeTime(cadastroPartidaDTO.getNomeTime2()));
        partida.setPontuacaoTime1(cadastroPartidaDTO.getPontuacaoTime1());
        partida.setPontuacaoTime2(cadastroPartidaDTO.getPontuacaoTime2());

        this.partidaRepository.save(partida);
    }


}
