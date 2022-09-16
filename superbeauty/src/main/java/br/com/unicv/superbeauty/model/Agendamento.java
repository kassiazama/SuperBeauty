package br.com.unicv.superbeauty.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
public class Agendamento implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codagendamento")
    private Integer codAgendamento;
    
    private Servico servico;
    
    private Empresa empresa;
    
    private Cliente cliente;
    
    private LocalDateTime horario;
    
    private LocalDate data;
    
    @ManyToOne
    @JoinColumn(name = "codColaborador", referencedColumnName = "codColaborador")
    private Colaborador colaborador;

    
  


}