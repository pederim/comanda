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
        SELECT c.garcom, SUM(c.valorTotalComanda) 
        FROM ComandaModel c 
        WHERE c.dataHoraAbertura BETWEEN :inicio AND :fim 
        AND c.status = 'Fechado'
        GROUP BY c.garcom
        ORDER BY SUM(c.valorTotalComanda) DESC
    """)
    Object[] listarFaturamentoPorGarcom(@Param("inicio") LocalDateTime inicio,
                                        @Param("fim") LocalDateTime fim);

    @Query("""
        SELECT c.formaPagamento.nome, COUNT(c.idComanda) 
        FROM ComandaModel c 
        JOIN c.formaPagamento f 
        WHERE c.dataHoraAbertura BETWEEN :inicio AND :fim 
        GROUP BY c.formaPagamento.nome
        ORDER BY COUNT(c.idComanda) DESC
    """)
    Object[] procurarFormaPagamentoMaisUtilizada(@Param("inicio") LocalDateTime inicio,
                                             @Param("fim") LocalDateTime fim);
}
