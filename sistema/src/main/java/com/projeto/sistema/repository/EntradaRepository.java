package com.projeto.sistema.repository;

import com.projeto.sistema.models.Entrada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntradaRepository extends JpaRepository <Entrada,Long>{

}
