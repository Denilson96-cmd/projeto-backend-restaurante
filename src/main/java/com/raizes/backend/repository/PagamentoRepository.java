package com.raizes.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.raizes.backend.domain.model.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}
