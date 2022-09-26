package br.com.unicv.superbeauty.service;

import java.time.LocalDateTime;
import java.util.List;

import br.com.unicv.superbeauty.model.Agendamento;
import br.com.unicv.superbeauty.model.Colaborador;

public interface AgendamentoService {
    
    public Agendamento cadastrar(Agendamento agendamento);

    public List<Agendamento> listar();

    public Agendamento buscarPorId(Integer codAgendamento); 

    public Agendamento buscarPorDataHora(LocalDateTime dataHora);

    public Agendamento buscarPorColaborador (Colaborador codColaborador);

    public Agendamento editar(Agendamento agendamento);

    public void excluir(Integer codAgendamento);

}