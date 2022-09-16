package br.com.unicv.superbeauty.service;

import java.util.List;

import br.com.unicv.superbeauty.model.Servico;

public interface ServicoService {

    public Servico cadastrar(Servico empresa);

    public Servico editar(Integer codEmpresa, Servico editado);

    public List<Servico> listar();

    public Servico buscarPorId(Integer codServico);

    public void excluir(Integer codServico);
    
}