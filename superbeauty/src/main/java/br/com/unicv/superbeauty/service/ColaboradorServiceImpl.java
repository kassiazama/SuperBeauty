package br.com.unicv.superbeauty.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unicv.superbeauty.exception.NotAcceptableException;
import br.com.unicv.superbeauty.exception.NotFoundException;
import br.com.unicv.superbeauty.model.Colaborador;
import br.com.unicv.superbeauty.repository.ColaboradorRepository;

@Service
public class ColaboradorServiceImpl implements ColaboradorService{

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @Override
    public Colaborador cadastrar(Colaborador colaborador) {
        boolean emailCadastrado = colaboradorRepository.findByEmail(colaborador.getEmail())
                                    .stream()
                                    .anyMatch(colaboradorExistente -> !colaboradorExistente.equals(colaborador));
        if (emailCadastrado) {
            throw new NotAcceptableException("O Email informado já está em uso");
        }

        return colaboradorRepository.save(colaborador);
    }

    @Override
    public List<Colaborador> listar() {
        return colaboradorRepository.findAll();
    }

    @Override
    public Colaborador buscarPorId(Integer codColaborador) {
        return colaboradorRepository.findById(codColaborador)
                .orElseThrow(() -> new NotFoundException("Colaborador não encontrado"));
    }

    @Override
    public Colaborador buscarPorEmail(String email) {
        return colaboradorRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("Colaborador não encontrado"));
    }

    @Override
    public Colaborador editar(Colaborador colaborador) {
        return colaboradorRepository.save(colaborador);
    }

    @Override
    public void excluir(Integer codColaborador) {
        colaboradorRepository.deleteById(codColaborador); 
    }

    
    
}