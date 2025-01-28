package br.com.boteco.comanda.service;

import br.com.boteco.comanda.rest.dto.ProdutoDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {
    @Override
    public List<ProdutoDTO> listarTodos() {
        return new ArrayList<>();
    }
}