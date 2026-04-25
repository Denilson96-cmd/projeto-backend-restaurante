package com.raizes.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.raizes.backend.domain.enums.CanalPedido;
import com.raizes.backend.domain.enums.StatusPedido;
import com.raizes.backend.domain.model.Pedido;
//  IMPORTAR QUE FALTAVA - OK
import com.raizes.backend.exception.ResourceNotFoundException;
import com.raizes.backend.repository.PedidoRepository;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    // =========================
    // CRIAR PEDIDO
    // =========================
    @PostMapping
    public Pedido criarPedido(@RequestBody Pedido pedido) {

        if (pedido.getItens() != null) {
            pedido.getItens().forEach(item -> item.setPedido(pedido));
        }

        return pedidoRepository.save(pedido);
    }

    // =========================
    // BUSCAR PEDIDO POR ID
    // =========================
    @GetMapping("/{id}")
    public Pedido buscarPorId(@PathVariable Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pedido não encontrado: " + id));
    }

    // =========================
    // LISTAR PEDIDOS (COM FILTRO + PAGINAÇÃO)
    // =========================
    @GetMapping
    public Page<Pedido> listarPedidos(
            @RequestParam(required = false) CanalPedido canalPedido,
            @RequestParam(required = false) StatusPedido status,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);

        if (canalPedido != null && status != null) {
            return pedidoRepository.findByCanalPedidoAndStatus(canalPedido, status, pageable);
        }

        if (canalPedido != null) {
            return pedidoRepository.findByCanalPedido(canalPedido, pageable);
        }

        if (status != null) {
            return pedidoRepository.findByStatus(status, pageable);
        }

        return pedidoRepository.findAll(pageable);
    }
}