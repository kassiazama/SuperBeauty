package br.com.unicv.superbeauty.service;

import java.util.List;

import br.com.unicv.superbeauty.model.Servico;

public interface ServicoService {

    public Servico cadastrar(Servico servico);

    public List<Servico> listar();

    public Servico buscarPorId(Integer codServico);

    public Servico editar(Servico servico);

    public void excluir(Integer codServico);
    
}