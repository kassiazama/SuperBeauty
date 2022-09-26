package br.com.unicv.superbeauty.service;

import java.util.List;

import br.com.unicv.superbeauty.model.Cliente;

public interface ClienteService {
    
    public Cliente cadastrar(Cliente cliente);

    public List<Cliente> listar();

    public Cliente buscarPorId(Integer codCliente);

    public Cliente buscarPorCpf(String cpf);

    public Cliente editar(Cliente cliente);

    public void excluir (Integer codCliente);

}