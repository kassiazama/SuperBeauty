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
    
    private LocalDateTime dataHora;
    
    @ManyToOne
    @JoinColumn(name = "codColaborador", referencedColumnName = "codcolaborador")
    private Colaborador colaborador;

    @ManyToOne
    @JoinColumn(name = "codServico", referencedColumnName = "codservico")
    private Servico servico;
    
    @ManyToOne
    @JoinColumn(name = "codEmpresa", referencedColumnName = "codempresa")
    private Empresa empresa;
    
    @ManyToOne
    @JoinColumn(name = "codCliente", referencedColumnName = "codcliente")
    private Cliente cliente;
    

    
  


}