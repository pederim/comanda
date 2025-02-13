package br.com.boteco.comanda.service;

import br.com.boteco.comanda.repository.ComandaRepository;
import br.com.boteco.comanda.rest.dto.ComandaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
public class ComandaServiceImpl implements ComandaService {

    @Autowired
    private ComandaRepository comandaRepository;

    @Transactional(readOnly = true)
    @Override
    public BigDecimal calcularFaturamentoTotal(LocalDateTime inicio, LocalDateTime fim) {
        BigDecimal total = comandaRepository.calcularFaturamentoTotal(inicio, fim);
        return total != null ? total : BigDecimal.ZERO;
    }


    @Override
    public List<ComandaDTO> listarTodas() {
        return List.of();
    }

    @Override
    public ComandaDTO criar(ComandaDTO comandaDTO) {
        return null;
    }
}
