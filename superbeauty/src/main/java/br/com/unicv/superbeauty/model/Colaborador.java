package br.com.unicv.superbeauty.model;

import java.time.LocalDate;

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
public class Colaborador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codColaborador")
    private Integer codColaborador;

    @Column(name = "nome")
    private String nome;

    @Column(name = "dataNascimento")
    private LocalDate dataNascimento;

    @Column(name = "email")
    private String email;

    @Column(name = "contato")
    private String contato;

    @Column(name = "dataContato")
    private LocalDate dataContato;

    @Column(name = "status")
    private boolean  status;

    @ManyToOne
    @JoinColumn(name = "codEmpresa", referencedColumnName = "codEmpresa")
    private Empresa empresa;

    



}
