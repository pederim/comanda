package br.com.boteco.comanda.service;

import br.com.boteco.comanda.exception.*;
import br.com.boteco.comanda.model.GarcomModel;
import br.com.boteco.comanda.repository.GarcomRepository;
import br.com.boteco.comanda.rest.dto.GarcomDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GarcomServiceImpl implements GarcomService {

    @Autowired
    private GarcomRepository garcomRepository;

    @Transactional(readOnly = true)
    @Override
    public List<GarcomDTO> obterTodos() {
        List<GarcomModel> garconsModels = garcomRepository.findAll();
        return garconsModels.stream()
                .map(GarcomModel::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public GarcomDTO obterGarcom(Long id) {
        GarcomModel garcomModel = garcomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Garçom não encontrado com ID: " + id));
        return garcomModel.toDTO();
    }

    @Transactional
    @Override
    public GarcomDTO salvar(GarcomModel novoGarcom) {
        if (garcomRepository.existsByCpf(novoGarcom.getCpf())) {
            throw new ConstraintException("Já existe um garçom com esse CPF " + novoGarcom.getCpf() + " na base de dados");
        }
        if (garcomRepository.existsByEmail(novoGarcom.getEmail())) {
            throw new ConstraintException("Já existe um garçom com esse Email " + novoGarcom.getEmail() + " na base de dados");
        }
        return garcomRepository.save(novoGarcom).toDTO();
    }

    @Transactional
    @Override
    public GarcomDTO atualizar(GarcomModel garcomExistente) {
        if (!garcomRepository.existsByCpf(garcomExistente.getCpf())) {
            throw new ConstraintException("O garçom com esse CPF " + garcomExistente.getCpf() + " não existe na base de dados");
        }
        if (!garcomRepository.existsByEmail(garcomExistente.getEmail())) {
            throw new ConstraintException("Não existe um garçom com esse Email " + garcomExistente.getEmail() + " na base de dados");
        }
        return garcomRepository.save(garcomExistente).toDTO();
    }

    @Transactional
    @Override
    public void deletar(GarcomModel garcomExistente) {
        if (!garcomRepository.existsByCpf(garcomExistente.getCpf())) {
            throw new ConstraintException("O garçom com esse CPF " + garcomExistente.getCpf() + " não existe na base de dados");
        }
        if (!garcomRepository.existsByEmail(garcomExistente.getEmail())) {
            throw new ConstraintException("Não existe um garçom com esse Email " + garcomExistente.getEmail() + " na base de dados");
        }
        garcomRepository.delete(garcomExistente);
    }
}
