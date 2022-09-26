package br.com.unicv.superbeauty.service;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.unicv.superbeauty.model.Colaborador;

@Component
public interface ColaboradorService {
  
    public Colaborador cadastrar(Colaborador colaborador);

    public List<Colaborador> listar();

    public Colaborador buscarPorId(Integer codColaborador); 

    public Colaborador buscarPorEmail(String email);

    public Colaborador editar(Colaborador colaborador);

    public void excluir(Integer codColaborador);
}