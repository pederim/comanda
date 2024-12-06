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
public class GarcomService {
    @Autowired
    private GarcomRepository garcomRepository;

    @Transactional(readOnly = true)
    public List<GarcomDTO> obterTodos() {
        List<GarcomModel> garconsModels = garcomRepository.findAll();
        return garconsModels.stream()
                .map(garcom -> garcom.toDTO())
                .collect(Collectors.toList());
    }

    @Transactional
    public GarcomDTO salvar(GarcomModel novoGarcom) {
        try {
            //caso ocorra uma tentativa de salvar um novo garçom com um cpf já existente
            if (garcomRepository.existsByCpf(novoGarcom.getCpf())) {
                throw new ConstraintException("Já existe um garçom com esse CPF " + novoGarcom.getCpf() + " na base de dados");
            }
            //caso ocorra uma tentativa de salvar um novo garçom com um email já existente
            if (garcomRepository.existsByEmail(novoGarcom.getEmail())) {
                throw new ConstraintException("Já existe um garçom com esse EmailF " + novoGarcom.getEmail() + " na base de dados");
            }
            // salva o garçom na base de dados
            return garcomRepository.save(novoGarcom).toDTO();

        } catch (DataIntegrityException e) {
            throw new DataIntegrityException("Erro! Não foi possível salvar o Garçom " + novoGarcom.getNome() + "! ");
        } catch (ConstraintException e) {
            throw new ConstraintException("Não foi possivel salvar o novo Garçom por causa de violação de integridade de dados");
        } catch (BusinessRuleException e) {
            throw new BusinessRuleException("Não foi possivel salvar o novo Garçom por causa de violação de regra de negócio");
        } catch (SQLException e) {
            throw new SQLException("Não foi possivel salvar o novo Garçom por falha na conexão do banco de dados");
        }
    }

    @Transactional
    public GarcomDTO atualizar(GarcomModel garcomExistente) {
        try {
            //caso ocorra uma tentativa de salvar um garçom que não exista com um cpf inexistente
            if (!garcomRepository.existsByCpf(garcomExistente.getCpf())) {
                throw new ConstraintException("O garçom com esse CPF " + garcomExistente.getCpf() + " não existe na base de dados");
            }
            //caso ocorra uma tentativa de salvar um novo garçom com um email  inexistente
            if (!garcomRepository.existsByEmail(garcomExistente.getEmail())) {
                throw new ConstraintException("Não existe um garçom com esse Email " + garcomExistente.getEmail() + " na base de dados");
            }
            // atualiza o garçom na base de dados
            return garcomRepository.save(garcomExistente).toDTO();

        } catch (DataIntegrityException e) {
            throw new DataIntegrityException("Erro! Não foi possível salvar o Garçom " + garcomExistente.getNome() + "! ");
        } catch (ConstraintException e) {
            throw new ConstraintException("Não foi possivel salvar o novo Garçom por causa de violação de integridade de dados");
        } catch (BusinessRuleException e) {
            throw new BusinessRuleException("Não foi possivel salvar o novo Garçom por causa de violação de regra de negócio");
        } catch (SQLException e) {
            throw new SQLException("Não foi possivel salvar o novo Garçom por falha na conexão do banco de dados");
        } catch (ObjectNotFoundException e){
            throw new ObjectNotFoundException("Não foi possível atualizar o garçom: Garçom =:" + garcomExistente.getNome() + "não encontrado");
        }
    }

    @Transactional
    public void deletar(GarcomModel garcomExistente) {
        try {
            //caso ocorra uma tentativa de deletar um garçom que não exista com um cpf inexistente
            if (!garcomRepository.existsByCpf(garcomExistente.getCpf())) {
                throw new ConstraintException("O garçom com esse CPF " + garcomExistente.getCpf() + " não existe na base de dados");
            }
            //caso ocorra uma tentativa de deletar um novo garçom com um email  inexistente
            if (!garcomRepository.existsByEmail(garcomExistente.getEmail())) {
                throw new ConstraintException("Não existe um garçom com esse Email " + garcomExistente.getEmail() + " na base de dados");
            }
            // deletar o garçom na base de dados
            garcomRepository.delete(garcomExistente);

        } catch (DataIntegrityException e) {
            throw new DataIntegrityException("Erro! Não foi possível deletar o Garçom " + garcomExistente.getNome() + "! ");
        } catch (ConstraintException e) {
            throw new ConstraintException("Não foi possivel deletar o novo Garçom por causa de violação de integridade de dados");
        } catch (BusinessRuleException e) {
            throw new BusinessRuleException("Não foi possivel deletar o novo Garçom por causa de violação de regra de negócio");
        } catch (SQLException e) {
            throw new SQLException("Não foi possivel deletar o novo Garçom por falha na conexão do banco de dados");
        } catch (ObjectNotFoundException e){
            throw new ObjectNotFoundException("Não foi possível deletar o garçom: Garçom =:" + garcomExistente.getNome() + "não encontrado");
        }
    }
}