package br.com.boteco.comanda.rest.controller;

import br.com.boteco.comanda.rest.dto.*;
import br.com.boteco.comanda.service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/comandas")
public class ComandaController {
    private final ComandaService comandaService;

    public ComandaController(ComandaService comandaService) {
        this.comandaService = comandaService;
    }

    @GetMapping
    public ResponseEntity<List<ComandaDTO>> listarTodas() {
        return ResponseEntity.ok(comandaService.listarTodas());
    }

    @PostMapping
    public ResponseEntity<ComandaDTO> criar(@RequestBody ComandaDTO comandaDTO) {
        return ResponseEntity.ok(comandaService.criar(comandaDTO));
    }
}