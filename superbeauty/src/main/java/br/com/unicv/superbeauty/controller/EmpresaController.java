package br.com.unicv.superbeauty.controller;

import java.rmi.ServerException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.unicv.superbeauty.model.Empresa;
import br.com.unicv.superbeauty.service.EmpresaServiceImpl;

@RestController
@RequestMapping(value = "/empresa")
public class EmpresaController {

    @Autowired
    private EmpresaServiceImpl empresaService;

    @GetMapping
    public ResponseEntity<List<Empresa>> listarEmpresas() {
        return ResponseEntity.status(HttpStatus.OK).body(empresaService.listar());
    }

    @PostMapping
    public ResponseEntity<Empresa> criar(@RequestBody Empresa novaEmpresa) {
        Empresa empresa = empresaService.cadastrar(novaEmpresa);
        if (empresa == null) {
            throw new RuntimeException();
        } else {
            return new ResponseEntity<>(empresa, HttpStatus.CREATED);
        }
    }
    }
    




    
