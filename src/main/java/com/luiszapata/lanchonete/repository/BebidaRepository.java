package com.luiszapata.lanchonete.repository;

import com.luiszapata.lanchonete.model.Bebida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BebidaRepository extends JpaRepository<Bebida, Long>{
    boolean existsByCodigo(String codigo);



}
