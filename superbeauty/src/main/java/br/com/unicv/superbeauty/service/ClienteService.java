package br.com.unicv.superbeauty.service;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.unicv.superbeauty.model.Cliente;

@Component
public interface ClienteService {
    
    public Cliente cadastrar(Cliente cliente);
    
    public Cliente editar(Cliente cliente);

    public List<Cliente> listar();

    public Cliente buscarPorId(Integer codCliente);

    public Cliente buscarPorCpf(String cpf);

    public void excluir (Integer codCliente);

}