package br.com.unicv.superbeauty.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unicv.superbeauty.model.Colaborador;

public interface ColaboradorRepository extends JpaRepository<Colaborador, Integer> {

    Optional<Colaborador> findByEmail(String email);
    
}