package br.com.unicv.superbeauty.service;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.unicv.superbeauty.model.Empresa;

@Component
public interface EmpresaService {

    public Empresa cadastrar(Empresa empresa);

    public Empresa editar(Integer codEmpresa, Empresa editado);

    public List<Empresa> listar();

    public Empresa buscarPorId(Integer codEmpresa); 

    public Empresa buscarPorCnpj(String cnpj);

    public void excluir(Integer codEmpresa);

}