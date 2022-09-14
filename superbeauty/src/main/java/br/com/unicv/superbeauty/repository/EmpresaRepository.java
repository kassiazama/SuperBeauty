package br.com.unicv.superbeauty.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unicv.superbeauty.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
    
}