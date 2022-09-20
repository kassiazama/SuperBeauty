package br.com.unicv.superbeauty.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping(value = "/cnpj")
    public ResponseEntity<Empresa> buscarPorCnpj(@RequestParam("cnpj") String cnpj) {
        return ResponseEntity.status(HttpStatus.OK).body(empresaService.buscarPorCnpj(cnpj));
    }

    @PostMapping
    public ResponseEntity<Empresa> criar(@RequestBody Empresa empresaNova) {
        Empresa empresa = empresaService.cadastrar(empresaNova);
        if (empresa == null) {
            throw new RuntimeException();
        } else {
            return new ResponseEntity<Empresa>(HttpStatus.CREATED);
        }
    }

    @PutMapping(value ="/{codEmpresa}")
    public ResponseEntity<Empresa> editar( @RequestBody Empresa empresaEditada) {
        return ResponseEntity.status(HttpStatus.OK).body(empresaService.editar(empresaEditada));
    }

    @DeleteMapping("/{codEmpresa}")
    public ResponseEntity<Void> excluir(@PathVariable("codEmpresa") Integer codEmpresa) {
       empresaService.excluir(codEmpresa);
        return ResponseEntity.noContent().build();
    }
}
    




    
