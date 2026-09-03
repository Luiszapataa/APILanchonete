package com.luiszapata.lanchonete.repository;

import com.luiszapata.lanchonete.model.Bebida;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BebidaRepository extends JpaRepository<Bebida, Long>{
    boolean existsByCodigo(String codigo);

    List<Bebida> findByCodigoContainingOrDescricaoContaining(String codigo, String descricao);

}


