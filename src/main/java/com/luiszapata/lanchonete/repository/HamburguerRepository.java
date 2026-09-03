package com.luiszapata.lanchonete.repository;

import com.luiszapata.lanchonete.model.Hamburguer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HamburguerRepository extends JpaRepository<Hamburguer, Long> {

    boolean existsByCodigo(String codigo);
    List<Hamburguer>findByCodigoContainingOrDescricaoContaining(String codigo, String descricao);


}
