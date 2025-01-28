package br.com.boteco.comanda.rest.controller;

import br.com.boteco.comanda.rest.dto.FormaPagamentoDTO;
import br.com.boteco.comanda.service.FormaPagamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/formaspagamento")
public class FormaPagamentoController {
    private final FormaPagamentoService formaPagamentoService;

    public FormaPagamentoController(FormaPagamentoService formaPagamentoService) {
        this.formaPagamentoService = formaPagamentoService;
    }

    @GetMapping
    public ResponseEntity<List<FormaPagamentoDTO>> listarTodos() {
        return ResponseEntity.ok(formaPagamentoService.listarTodos());
    }
}