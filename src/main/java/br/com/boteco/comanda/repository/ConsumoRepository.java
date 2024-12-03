package br.com.boteco.comanda.repository;

import br.com.boteco.comanda.model.ConsumoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumoRepository extends JpaRepository<ConsumoModel, Long> {
}
