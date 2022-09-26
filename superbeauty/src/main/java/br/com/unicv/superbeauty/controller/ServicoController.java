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
import org.springframework.web.bind.annotation.RestController;

import br.com.unicv.superbeauty.model.Servico;
import br.com.unicv.superbeauty.service.ServicoService;

@RestController
@RequestMapping(value = "/servico")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @GetMapping
    public ResponseEntity<List<Servico>> listarServico() {
        return ResponseEntity.status(HttpStatus.OK).body(servicoService.listar());
    }

    @PostMapping()
    public ResponseEntity<Servico> criar(@RequestBody Servico servicoNovo) {
        return ResponseEntity.status(HttpStatus.OK).body(servicoService.cadastrar(servicoNovo));
    }

    @PutMapping
    public ResponseEntity<Servico> editar(@RequestBody Servico servicoEditado) {
        return ResponseEntity.status(HttpStatus.OK).body(servicoService.editar(servicoEditado));
    }

    @DeleteMapping("/{codServico}")
    public ResponseEntity<String> excluir(@PathVariable("codServico") Integer codServico) {
        servicoService.excluir(codServico);
        return ResponseEntity.status(HttpStatus.OK).body("Servico excluído com sucesso");
    }

}