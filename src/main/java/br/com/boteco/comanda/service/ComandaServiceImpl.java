package br.com.boteco.comanda.service;

import br.com.boteco.comanda.rest.dto.*;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class ComandaServiceImpl implements ComandaService {
    @Override
    public List<ComandaDTO> listarTodas() {
        return new ArrayList<>();
    }

    @Override
    public ComandaDTO criar(ComandaDTO comandaDTO) {
        return comandaDTO;
    }
}