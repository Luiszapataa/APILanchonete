package com.luiszapata.lanchonete.repository;

import com.luiszapata.lanchonete.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    boolean existsByCodigo(String codigo);
    List<Pedido> findByCodigoContainingOrDescricaoContaining(String codigo, String descricao);


}
