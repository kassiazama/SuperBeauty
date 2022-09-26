package br.com.unicv.superbeauty.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unicv.superbeauty.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
    
    Optional<Empresa> findByCnpj(String cnpj);

}