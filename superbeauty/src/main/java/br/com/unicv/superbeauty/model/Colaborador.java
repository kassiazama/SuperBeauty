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
    @Column(name = "codcolaborador")
    private Integer codColaborador;

    private String nome;

    @Column(name = "datanascimento")
    private LocalDate dataNascimento;

    private String email;

    private String celular;

    @Column(name = "datacontrato")
    private LocalDate dataContato;

    private boolean status;

    @ManyToOne
    @JoinColumn(name = "codempresa", referencedColumnName = "codEmpresa")
    private Empresa empresa;

}
