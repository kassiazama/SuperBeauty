package br.com.unicv.superbeauty.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unicv.superbeauty.repository.EmpresaRepository;

@Service
public class EmpresaServiceImpl {

    @Autowired
    private EmpresaRepository empresaRepository;

    

}