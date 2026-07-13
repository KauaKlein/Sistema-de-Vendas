package com.projeto.sistema.repository;

import com.projeto.sistema.models.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository <Funcionario,Long>{

}
