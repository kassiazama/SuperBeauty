package br.com.unicv.superbeauty.service;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.unicv.superbeauty.model.Empresa;

@Component
public interface EmpresaService {

    public List<Empresa> listar();

    public Empresa buscarPorCnpj(); 
    

    
}