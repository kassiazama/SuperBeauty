package br.com.unicv.superbeauty.controller;

import java.util.List;

import javax.validation.Valid;

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

import br.com.unicv.superbeauty.model.Colaborador;
import br.com.unicv.superbeauty.service.ColaboradorService;

@RestController
@RequestMapping(value = "/colaborador")
public class ColaboradorController {

    @Autowired
    private ColaboradorService colaboradorService;

    @GetMapping
    public ResponseEntity<List<Colaborador>> listarColaboradores() {
        return ResponseEntity.status(HttpStatus.OK).body(colaboradorService.listar());
    }

    @GetMapping(value = "/email")
    public ResponseEntity<Colaborador> buscarPorEmail(@RequestParam("email") String email) {
        return ResponseEntity.status(HttpStatus.OK).body(colaboradorService.buscarPorEmail(email));
    }

    @PostMapping()
    public ResponseEntity<Colaborador> criar(@Valid @RequestBody Colaborador colaboradorNovo) {
        return ResponseEntity.status(HttpStatus.OK).body(colaboradorService.cadastrar(colaboradorNovo));
    }

    @PutMapping()
    public ResponseEntity<Colaborador> editar(@RequestBody Colaborador colaboradorEditado) {
        return ResponseEntity.status(HttpStatus.OK).body(colaboradorService.editar(colaboradorEditado));
    }

    @DeleteMapping("/{codColaborador}")
    public ResponseEntity<String> excluir(@PathVariable("codColaborador") Integer codColaborador) {
        colaboradorService.excluir(codColaborador);
        return ResponseEntity.status(HttpStatus.OK).body("Colaborador excluído com sucesso");
    }
}