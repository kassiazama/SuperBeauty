package br.com.unicv.superbeauty.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unicv.superbeauty.exception.NegocioException;
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
            throw new NegocioException("O CNPJ informado já está em uso");
            // arrumar essa exceção 
        }
        return empresaRepository.save(empresa);
    }

    @Override
    public Empresa editar(Integer codEmpresa, Empresa editado) {
        
        var empresaCadastrada = buscarPorId(codEmpresa);
        if (Objects.isNull(empresaCadastrada)){
            throw new RuntimeException("Empresa não encontrada");
        } 
        // empresaCadastrada.setRazaoSocial(editado.getRazaoSocial());
        // empresaCadastrada.setCnpj(editado.getCnpj());
        // empresaCadastrada.setStatus(editado.isStatus());
        // empresaCadastrada.setLogradouro(editado.getLogradouro());
        // empresaCadastrada.setBairro(editado.getBairro());
        // empresaCadastrada.setCep(editado.getCep());

        //transformar em uma função lambda?

        return empresaRepository.save(editado);
    }

    @Override
    public List<Empresa> listar() {
        return empresaRepository.findAll();
    }

    @Override
    public Empresa buscarPorId(Integer codEmpresa) {
        return empresaRepository.findById(codEmpresa).orElseThrow(() -> new NegocioException("Empresa não encontrada"));
    }

    @Override
    public Empresa buscarPorCnpj(String cnpj) {
        return empresaRepository.findByCnpj(cnpj).orElseThrow(() -> new NegocioException("Empresa não encontrada"));
    }

    @Override
    public void excluir(Integer codEmpresa) {
        empresaRepository.deleteById(codEmpresa);

    }

}