package br.com.unicv.superbeauty.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unicv.superbeauty.model.Agendamento;
import br.com.unicv.superbeauty.model.Colaborador;


public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer> {
    
    Optional<Agendamento> findByDataHora(LocalDateTime dataHora);
    Optional<Agendamento> findByColaborador(Colaborador colaborador);

}