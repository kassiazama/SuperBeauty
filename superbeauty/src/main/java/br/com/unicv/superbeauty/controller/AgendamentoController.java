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

import br.com.unicv.superbeauty.model.Agendamento;
import br.com.unicv.superbeauty.service.AgendamentoServiceImpl;

@RestController
@RequestMapping(value = "/agendamento")
public class AgendamentoController {
    
    @Autowired
    private AgendamentoServiceImpl agendamentoService;

    @GetMapping
    public ResponseEntity<List<Agendamento>> listarAgendamento() {
        return ResponseEntity.status(HttpStatus.OK).body(agendamentoService.listar());
    }

    @PostMapping
    public ResponseEntity<Agendamento> criar(@RequestBody Agendamento agendamentoNova) {
        Agendamento agendamento = agendamentoService.cadastrar(agendamentoNova);
        if (agendamento == null) {
            throw new RuntimeException();
        } else {
            return new ResponseEntity<Agendamento>(HttpStatus.CREATED);
        }
    }

    @PutMapping(value ="/{codAgendamento}")
    public ResponseEntity<Agendamento> editar( @RequestBody Agendamento agendamentoEditada) {
        return ResponseEntity.status(HttpStatus.OK).body(agendamentoService.editar(agendamentoEditada));
    }

    @DeleteMapping("/{codAgendamento}")
    public ResponseEntity<Void> excluir(@PathVariable("codAgendamento") Integer codAgendamento) {
       agendamentoService.excluir(codAgendamento);
        return ResponseEntity.noContent().build();
    }
}