package br.com.boteco.comanda.service;

import br.com.boteco.comanda.rest.dto.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface ComandaService {
    List<ComandaDTO> listarTodas();
    ComandaDTO criar(ComandaDTO comandaDTO);
    BigDecimal calcularFaturamentoTotal(LocalDateTime inicio, LocalDateTime fim);
}
