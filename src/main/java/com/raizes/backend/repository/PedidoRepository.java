package com.raizes.backend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.raizes.backend.domain.enums.CanalPedido;
import com.raizes.backend.domain.enums.StatusPedido;
import com.raizes.backend.domain.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    Page<Pedido> findByCanalPedidoAndStatus(CanalPedido canalPedido, StatusPedido status, Pageable pageable);

    Page<Pedido> findByCanalPedido(CanalPedido canalPedido, Pageable pageable);

    Page<Pedido> findByStatus(StatusPedido status, Pageable pageable);
}