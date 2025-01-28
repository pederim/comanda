package br.com.boteco.comanda.service;

import br.com.boteco.comanda.rest.dto.MesaDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MesaServiceImpl implements MesaService {
    @Override
    public List<MesaDTO> listarTodas() {
        return new ArrayList<>();
    }
}