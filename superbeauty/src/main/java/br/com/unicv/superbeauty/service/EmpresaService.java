package br.com.unicv.superbeauty.service;

import java.util.List;

import br.com.unicv.superbeauty.model.Empresa;


public interface EmpresaService {

    public Empresa cadastrar(Empresa empresa);

    public List<Empresa> listar();

    public Empresa buscarPorId(Integer codEmpresa); 

    public Empresa buscarPorCnpj(String cnpj);

    public Empresa editar(Empresa empresa);

    public void excluir(Integer codEmpresa);

}