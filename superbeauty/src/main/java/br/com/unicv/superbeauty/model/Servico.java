package br.com.unicv.superbeauty.model;

import java.io.Serializable;

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
public class Servico implements Serializable { 

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codservico")
    private Integer codServico;

    private String descricao;

    private int duracao;
    
    @Column(name = "valorservico")
    private double valorServico;

    @ManyToOne
    @JoinColumn(name = "codempresa", referencedColumnName = "codEmpresa")
    private Empresa empresa;

}