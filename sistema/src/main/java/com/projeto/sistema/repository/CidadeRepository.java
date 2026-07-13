package com.projeto.sistema.repository;

import com.projeto.sistema.models.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository <Cidade,Long>{

}
