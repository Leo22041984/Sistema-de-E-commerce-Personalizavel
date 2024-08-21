package com.exemplo.ecommerce.repository;

import com.exemplo.ecommerce.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Repositório para Funcionário
@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    Funcionario findByEmail(String email);
}
