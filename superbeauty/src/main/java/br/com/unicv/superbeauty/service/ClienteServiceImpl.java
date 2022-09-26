package br.com.unicv.superbeauty.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unicv.superbeauty.exception.NotAcceptableException;
import br.com.unicv.superbeauty.exception.NotFoundException;
import br.com.unicv.superbeauty.model.Cliente;
import br.com.unicv.superbeauty.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente cadastrar(Cliente cliente) {
        boolean cpfCadastrado = clienteRepository.findByCpf(cliente.getCpf())
                                .stream()
                                .anyMatch(clienteExistente -> !clienteExistente.equals(cliente));
        if(cpfCadastrado) {
            throw new NotAcceptableException("O CPF informado já está em uso");
        }
        
        return clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Integer codCliente) {
        return clienteRepository.findById(codCliente)
                .orElseThrow(() -> new NotFoundException("Cliente não encontrado"));
    }

    @Override
    public Cliente buscarPorCpf(String cpf) {
        return clienteRepository.findByCpf(cpf)
                .orElseThrow(() -> new NotFoundException("Cliente não encontrado"));
    }

    @Override
    public Cliente editar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public void excluir(Integer codCliente) {
        clienteRepository.deleteById(codCliente);
        
    }
}