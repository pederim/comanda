package br.com.boteco.comanda.service;

import br.com.boteco.comanda.repository.ConsumoRepository;
import br.com.boteco.comanda.repository.ProdutoRepository;
import br.com.boteco.comanda.rest.dto.ProdutoDTO;
import br.com.boteco.comanda.model.ProdutoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ConsumoRepository consumoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional(readOnly = true)
    public ProdutoDTO obterProdutoMaisVendido(LocalDateTime inicio, LocalDateTime fim) {
        Object[] resultado = consumoRepository.findProdutoMaisVendido(inicio, fim);
        if (resultado == null) {
            return new ProdutoDTO(null, "Nenhum produto encontrado", 0);
        }
        ProdutoModel produto = produtoRepository.findById((Long) resultado[0])
                .orElse(null);
        if (produto != null) {
            ProdutoDTO produtoDTO = produto.toDTO();
            produtoDTO.setQuantidadeVendida((Long) resultado[1]);
            return produtoDTO;
        }
        return new ProdutoDTO(null, "Produto não encontrado", 0);
    }

    @Override
    public List<ProdutoDTO> listarTodos() {
        return List.of();
    }
}
