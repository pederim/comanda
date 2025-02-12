package br.com.boteco.comanda.service;

import br.com.boteco.comanda.rest.dto.GarcomDTO;
import br.com.boteco.comanda.model.GarcomModel;

import java.time.LocalDateTime;
import java.util.List;

public interface GarcomService {
    List<GarcomDTO> obterTodos();
    GarcomDTO obterGarcom(Long id);
    GarcomDTO salvar(GarcomModel novoGarcom);
    GarcomDTO atualizar(GarcomModel garcomExistente);
    void deletar(GarcomModel garcomExistente);
    GarcomDTO obterGarcomMaiorFaturamento(LocalDateTime inicio, LocalDateTime fim);
}
