package br.com.boteco.comanda.repository;

import br.com.boteco.comanda.model.ConsumoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;

@Repository
public interface ConsumoRepository extends JpaRepository<ConsumoModel, Long> {

    @Query("""
        SELECT c.produto.id, SUM(c.quantidade) 
        FROM ConsumoModel c 
        WHERE c.dataHoraConsumo BETWEEN :inicio AND :fim 
        AND c.comanda.status = 'Fechado' 
        GROUP BY c.produto.id 
        ORDER BY SUM(c.quantidade) DESC
    """)
    Object[] findProdutoMaisVendido(@Param("inicio") LocalDateTime inicio,
                                    @Param("fim") LocalDateTime fim);
}
