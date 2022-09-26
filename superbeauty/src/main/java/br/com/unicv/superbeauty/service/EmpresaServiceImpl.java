package br.com.unicv.superbeauty.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unicv.superbeauty.exception.NotAcceptableException;
import br.com.unicv.superbeauty.exception.NotFoundException;
import br.com.unicv.superbeauty.model.Empresa;
import br.com.unicv.superbeauty.repository.EmpresaRepository;

@Service
public class EmpresaServiceImpl implements EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Override
    public Empresa cadastrar(Empresa empresa) {
        boolean cnpjCadastrado = empresaRepository.findByCnpj(empresa.getCnpj())
                                    .stream()
                                    .anyMatch(empresaExistente -> !empresaExistente.equals(empresa));
        if (cnpjCadastrado) {
            throw new NotAcceptableException("O CNPJ informado já está em uso");
        }

        return empresaRepository.save(empresa);
    }

    @Override
    public List<Empresa> listar() {
        return empresaRepository.findAll();
    }

    @Override
    public Empresa buscarPorId(Integer codEmpresa) {
        return empresaRepository.findById(codEmpresa)
                .orElseThrow(() -> new NotFoundException("Empresa não encontrada"));
    }

    @Override
    public Empresa buscarPorCnpj(String cnpj) {
        return empresaRepository.findByCnpj(cnpj)
                .orElseThrow(() -> new NotFoundException("Empresa não encontrada"));
    }

    @Override
    public Empresa editar(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    @Override
    public void excluir(Integer codEmpresa) {
        empresaRepository.deleteById(codEmpresa);
    }
}