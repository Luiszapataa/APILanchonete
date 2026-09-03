package com.luiszapata.lanchonete.repository;

import com.luiszapata.lanchonete.model.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Long> {
    boolean existsByCodigo(String codigo);
    List<Ingrediente> findByCodigoContainingOrDescricaoContaining(String codigo, String descricao);
}
