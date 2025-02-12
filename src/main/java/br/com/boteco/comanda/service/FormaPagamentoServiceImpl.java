package br.com.boteco.comanda.service;

import br.com.boteco.comanda.repository.ComandaRepository;
import br.com.boteco.comanda.repository.FormaPagamentoRepository;
import br.com.boteco.comanda.rest.dto.FormaPagamentoDTO;
import br.com.boteco.comanda.model.FormaPagamentoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class FormaPagamentoServiceImpl implements FormaPagamentoService {

    @Autowired
    private ComandaRepository comandaRepository;

    @Autowired
    private FormaPagamentoRepository formaPagamentoRepository;

    @Transactional(readOnly = true)
    public FormaPagamentoDTO obterFormaPagamentoMaisUtilizada(LocalDateTime inicio, LocalDateTime fim) {
        Object[] resultado = comandaRepository.procurarFormaPagamentoMaisUtilizada(inicio, fim);
        if (resultado == null) {
            return new FormaPagamentoDTO(null, "Nenhuma forma de pagamento encontrada", 0);
        }
        FormaPagamentoModel formaPagamento = formaPagamentoRepository.findById((Long) resultado[0])
                .orElse(null);
        if (formaPagamento != null) {
            FormaPagamentoDTO formaPagamentoDTO = formaPagamento.toDTO();
            formaPagamentoDTO.setQuantidadeUsos((Long) resultado[1]);
            return formaPagamentoDTO;
        }
        return new FormaPagamentoDTO(null, "Forma de pagamento não encontrada", 0);
    }

    @Override
    public List<FormaPagamentoDTO> listarTodos() {
        return new ArrayList<>();
    }
}
