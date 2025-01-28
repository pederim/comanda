package br.com.boteco.comanda.rest.controller;

import br.com.boteco.comanda.rest.dto.ConsumoDTO;
import br.com.boteco.comanda.service.ConsumoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/consumos")
public class ConsumoController {
    private final ConsumoService consumoService;

    public ConsumoController(ConsumoService consumoService) {
        this.consumoService = consumoService;
    }

    @GetMapping
    public ResponseEntity<List<ConsumoDTO>> listarTodos() {
        return ResponseEntity.ok(consumoService.listarTodos());
    }
}