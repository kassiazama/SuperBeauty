package br.com.unicv.superbeauty.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unicv.superbeauty.exception.NotAcceptableException;
import br.com.unicv.superbeauty.exception.NotFoundException;
import br.com.unicv.superbeauty.model.Agendamento;
import br.com.unicv.superbeauty.repository.AgendamentoRepository;

@Service
public class AgendamentoServiceImpl implements AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Override
    public Agendamento cadastrar(Agendamento agendamento) {
        boolean horarioDisponivel = agendamentoRepository.findByDataHora(agendamento.getDataHora())
                .stream()
                .anyMatch(agendamentoExistente -> !agendamentoExistente.equals(agendamento));
        if (horarioDisponivel) {
            throw new NotAcceptableException("A Data e a hora estão indisponiveis");
        }

        return agendamentoRepository.save(agendamento);
    }

    @Override
    public Agendamento editar(Agendamento agendamento) {
        return agendamentoRepository.save(agendamento);
    }

    @Override
    public List<Agendamento> listar() {
        return agendamentoRepository.findAll();
    }

    @Override
    public Agendamento buscarPorId(Integer codAgendamento) {
        return agendamentoRepository.findById(codAgendamento)
                .orElseThrow(() -> new NotFoundException("Agendamento não encontrado"));
    }

    @Override
    public Agendamento buscarPorDataHora(LocalDateTime dataHora) {
        return agendamentoRepository.findByDataHora(dataHora)
                .orElseThrow(() -> new NotFoundException("Data e hora não encontrado"));
    }

    @Override
    public void excluir(Integer codAgendamento) {
        agendamentoRepository.deleteById(codAgendamento);

    }

}