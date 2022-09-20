package br.com.unicv.superbeauty.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unicv.superbeauty.model.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer>{
    
    Optional<Agendamento> findByDataHora(LocalDateTime dataHora);

}