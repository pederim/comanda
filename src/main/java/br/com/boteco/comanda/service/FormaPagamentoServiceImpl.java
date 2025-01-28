package br.com.boteco.comanda.service;

import br.com.boteco.comanda.rest.dto.FormaPagamentoDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FormaPagamentoServiceImpl implements FormaPagamentoService {
    @Override
    public List<FormaPagamentoDTO> listarTodos() {
        return new ArrayList<>();
    }
}