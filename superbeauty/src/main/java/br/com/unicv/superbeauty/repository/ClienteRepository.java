package br.com.unicv.superbeauty.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unicv.superbeauty.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    Optional<Cliente> findByCpf(String cpf);

}