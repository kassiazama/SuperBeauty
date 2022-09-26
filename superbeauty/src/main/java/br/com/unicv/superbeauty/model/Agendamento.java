package br.com.unicv.superbeauty.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

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
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
    @Column(name = "datahora")
    private LocalDateTime dataHora;
    
    @ManyToOne
    @JoinColumn(name = "codcolaborador", referencedColumnName = "codColaborador")
    private Colaborador colaborador;

    @ManyToOne
    @JoinColumn(name = "codservico", referencedColumnName = "codServico")
    private Servico servico;
    
    @ManyToOne
    @JoinColumn(name = "codempresa", referencedColumnName = "codEmpresa")
    private Empresa empresa;
    
    @ManyToOne
    @JoinColumn(name = "codcliente", referencedColumnName = "codCliente")
    private Cliente cliente;

}