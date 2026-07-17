package com.projeto.sistema.repository;

import com.projeto.sistema.models.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends JpaRepository <Venda,Long>{

}
