package com.luiszapata.lanchonete.repository;

import com.luiszapata.lanchonete.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
