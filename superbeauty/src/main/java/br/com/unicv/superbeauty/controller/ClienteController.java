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

import br.com.unicv.superbeauty.model.Cliente;
import br.com.unicv.superbeauty.service.ClienteService;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.listar());
    }

    @GetMapping(value = "/cpf")
    public ResponseEntity<Cliente> buscarPorCpf(@RequestParam("cpf") String cpf) {
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.buscarPorCpf(cpf));
    }

    @PostMapping()
    public ResponseEntity<Cliente> criar(@RequestBody Cliente clienteNovo) {
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.cadastrar(clienteNovo));
    }

    @PutMapping
    public ResponseEntity<Cliente> editar(@RequestBody Cliente clienteEditado) {
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.editar(clienteEditado));
    }

    @DeleteMapping("/{codCliente}")
    public ResponseEntity<String> excluir(@PathVariable("codCliente") Integer codCliente) {
        clienteService.excluir(codCliente);
        return ResponseEntity.status(HttpStatus.OK).body("Cliente excluído com sucesso");
    }
}