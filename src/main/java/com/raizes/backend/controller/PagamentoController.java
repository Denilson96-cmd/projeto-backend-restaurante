package com.raizes.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.raizes.backend.domain.enums.StatusPagamento;
import com.raizes.backend.domain.enums.StatusPedido;
import com.raizes.backend.domain.model.Pagamento;
import com.raizes.backend.domain.model.Pedido;
import com.raizes.backend.repository.PagamentoRepository;
import com.raizes.backend.repository.PedidoRepository;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    //  REALIZAR PAGAMENTO
    @PostMapping("/{pedidoId}")
    public Pagamento pagarPedido(@PathVariable Long pedidoId) {

        Pedido pedido = pedidoRepository.findById(pedidoId)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        Pagamento pagamento = new Pagamento();
        pagamento.setPedido(pedido);
        pagamento.setStatus(StatusPagamento.APROVADO);

        pedido.setStatus(StatusPedido.PAGO);

        pedidoRepository.save(pedido);

        return pagamentoRepository.save(pagamento);
    }
}