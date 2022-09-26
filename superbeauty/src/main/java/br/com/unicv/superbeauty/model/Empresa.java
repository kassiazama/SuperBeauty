package br.com.unicv.superbeauty.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
public class Empresa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codempresa")
    private Integer codEmpresa;

    private String cnpj;

    @Column(name = "razaosocial")
    private String razaoSocial;

    private boolean status;
    
    private String logradouro;
    private String numero;
    private String bairro;
    private String cep;
    
}