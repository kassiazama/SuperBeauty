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
import br.com.unicv.superbeauty.service.AgendamentoService;

@RestController
@RequestMapping(value = "/agendamento")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @GetMapping
    public ResponseEntity<List<Agendamento>> listarAgendamento() {
        return ResponseEntity.status(HttpStatus.OK).body(agendamentoService.listar());
    }

    @PostMapping()
    public ResponseEntity<Agendamento> criar(@RequestBody Agendamento agendamentoNovo) {
        return ResponseEntity.status(HttpStatus.OK).body(agendamentoService.cadastrar(agendamentoNovo));
    }

    @PutMapping()
    public ResponseEntity<Agendamento> editar(@RequestBody Agendamento agendamentoEditado) {
        return ResponseEntity.status(HttpStatus.OK).body(agendamentoService.editar(agendamentoEditado));
    }

    @DeleteMapping("/{codAgendamento}")
    public ResponseEntity<String> excluir(@PathVariable("codAgendamento") Integer codAgendamento) {
        agendamentoService.excluir(codAgendamento);
        return ResponseEntity.status(HttpStatus.OK).body("Agendamento excluído com sucesso");
    }
}