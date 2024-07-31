package br.com.ricardo.HoopersMatch.Services;

import br.com.ricardo.HoopersMatch.Models.Arbitro;
import br.com.ricardo.HoopersMatch.Models.DTO.CadastroPartidaDTO;
import br.com.ricardo.HoopersMatch.Models.Partida;
import br.com.ricardo.HoopersMatch.Models.Time;
import br.com.ricardo.HoopersMatch.Repositories.ArbitroRepository;
import br.com.ricardo.HoopersMatch.Repositories.PartidaRepository;
import br.com.ricardo.HoopersMatch.Repositories.TimeRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
        if (!StringUtils.hasText(cadastroPartidaDTO.getNomeArbitro())) {
            throw new IllegalArgumentException("O nome do árbitro não pode estar em branco");
        }

        if (!StringUtils.hasText(cadastroPartidaDTO.getNomeTime1())) {
            throw new IllegalArgumentException("O nome do Time 1 não pode estar em branco");
        }

        if (!StringUtils.hasText(cadastroPartidaDTO.getNomeTime2())) {
            throw new IllegalArgumentException("O nome do Time 2 não pode estar em branco");
        }

        if (cadastroPartidaDTO.getPontuacaoTime1() < 0) {
            throw new IllegalArgumentException("A pontuação do Time 1 não pode ser negativa");
        }

        if (cadastroPartidaDTO.getPontuacaoTime2() < 0) {
            throw new IllegalArgumentException("A pontuação do Time 2 não pode ser negativa");
        }

        Arbitro arbitro = arbitroRepository.findArbitroByNome(cadastroPartidaDTO.getNomeArbitro());
        if (arbitro == null) {
            throw new IllegalArgumentException("Árbitro não encontrado: " + cadastroPartidaDTO.getNomeArbitro());
        }

        Time time1 = timeRepository.findByNomeTime(cadastroPartidaDTO.getNomeTime1());
        if (time1 == null) {
            throw new IllegalArgumentException("Time 1 não encontrado: " + cadastroPartidaDTO.getNomeTime1());
        }

        Time time2 = timeRepository.findByNomeTime(cadastroPartidaDTO.getNomeTime2());
        if (time2 == null) {
            throw new IllegalArgumentException("Time 2 não encontrado: " + cadastroPartidaDTO.getNomeTime2());
        }

        Partida partida = new Partida();
        partida.setArbitro(arbitro);
        partida.setTime1(time1);
        partida.setTime2(time2);
        partida.setPontuacaoTime1(cadastroPartidaDTO.getPontuacaoTime1());
        partida.setPontuacaoTime2(cadastroPartidaDTO.getPontuacaoTime2());

        this.partidaRepository.save(partida);
    }
}
