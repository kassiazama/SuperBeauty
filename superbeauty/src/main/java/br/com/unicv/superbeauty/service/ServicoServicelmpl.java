package br.com.unicv.superbeauty.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unicv.superbeauty.exception.NotFoundException;
import br.com.unicv.superbeauty.model.Servico;
import br.com.unicv.superbeauty.repository.ServicoRepository;

@Service
public class ServicoServicelmpl implements ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    @Override
    public Servico cadastrar(Servico servico) {
        return servicoRepository.save(servico);
    }

    @Override
    public List<Servico> listar() {
        return servicoRepository.findAll();
    }

    @Override
    public Servico buscarPorId(Integer codServico) {
        return servicoRepository.findById(codServico)
                .orElseThrow(() -> new NotFoundException("Serviço não encontrado"));
    }

    @Override
    public Servico editar(Servico servico) {
        return servicoRepository.save(servico);
    }

    @Override
    public void excluir(Integer codServico) {
        servicoRepository.deleteById(codServico);

    }
}
