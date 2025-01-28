package br.com.boteco.comanda.service;

import br.com.boteco.comanda.rest.dto.ConsumoDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsumoServiceImpl implements ConsumoService {
    @Override
    public List<ConsumoDTO> listarTodos() {
        return new ArrayList<>();
    }
}