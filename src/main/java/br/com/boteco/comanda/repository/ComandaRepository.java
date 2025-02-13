package br.com.boteco.comanda.repository;

import br.com.boteco.comanda.model.ComandaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Repository
public interface ComandaRepository extends JpaRepository<ComandaModel, Long> {

    @Query("""
        SELECT c.garcom, SUM(c.valorTotalComanda) 
        FROM ComandaModel c 
        WHERE c.dataHoraAbertura BETWEEN :inicio AND :fim 
        AND c.status = 'Fechado' 
        GROUP BY c.garcom
        ORDER BY SUM(c.valorTotalComanda) DESC
    """)
    Object[] findGarcomMaiorFaturamento(@Param("inicio") LocalDateTime inicio,
                                        @Param("fim") LocalDateTime fim);

    @Query("""
        SELECT COALESCE(SUM(c.valorTotalComanda), 0) 
        FROM ComandaModel c 
        WHERE c.dataHoraAbertura BETWEEN :inicio AND :fim 
        AND c.status = 'Fechado'
    """)
    BigDecimal calcularFaturamentoTotal(@Param("inicio") LocalDateTime inicio,
                                        @Param("fim") LocalDateTime fim);

    @Query("""
        SELECT c.formaPagamento, COUNT(c.idComanda) 
        FROM ComandaModel c 
        WHERE c.dataHoraFechamento BETWEEN :inicio AND :fim 
        AND c.status = 'Fechado'
        GROUP BY c.formaPagamento
        ORDER BY COUNT(c.idComanda) DESC
    """)
    Object[] procurarFormaPagamentoMaisUtilizada(@Param("inicio") LocalDateTime inicio,
                                                 @Param("fim") LocalDateTime fim);
}
