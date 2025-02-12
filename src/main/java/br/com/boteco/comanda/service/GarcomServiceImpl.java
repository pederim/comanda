package br.com.boteco.comanda.service;

import br.com.boteco.comanda.exception.*;
import br.com.boteco.comanda.model.GarcomModel;
import br.com.boteco.comanda.repository.ComandaRepository;
import br.com.boteco.comanda.repository.GarcomRepository;
import br.com.boteco.comanda.rest.dto.GarcomDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class GarcomServiceImpl implements GarcomService {

    @Autowired
    private GarcomRepository garcomRepository;

    @Autowired
    private ComandaRepository comandaRepository;

    @Transactional(readOnly = true)
    @Override
    public List<GarcomDTO> obterTodos() {
        return garcomRepository.findAll().stream()
                .map(GarcomModel::toDTO)
                .toList();
    }

    @Transactional(readOnly = true)
    @Override
    public GarcomDTO obterGarcom(Long id) {
        GarcomModel garcomModel = garcomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Garçom não encontrado com ID: " + id));
        return garcomModel.toDTO();
    }

    @Override
    public GarcomDTO salvar(GarcomModel novoGarcom) {
        return null;
    }

    @Override
    public GarcomDTO atualizar(GarcomModel garcomExistente) {
        return null;
    }

    @Override
    public void deletar(GarcomModel garcomExistente) {

    }

    @Transactional(readOnly = true)
    public GarcomDTO obterGarcomMaiorFaturamento(LocalDateTime inicio, LocalDateTime fim) {
        Object[] resultado = comandaRepository.findGarcomMaiorFaturamento(inicio, fim);
        if (resultado == null) {
            return new GarcomDTO(null, "Nenhum garçom encontrado", BigDecimal.ZERO);
        }

        GarcomModel garcom = garcomRepository.findById((Long) resultado[0])
                .orElse(null);

        if (garcom != null) {
            // Criar o DTO passando o faturamento direto no construtor
            return new GarcomDTO(garcom.getIdGarcom(), garcom.getNome(), (BigDecimal) resultado[1]);
        }

        return new GarcomDTO(null, "Garçom não encontrado", BigDecimal.ZERO);
    }

}