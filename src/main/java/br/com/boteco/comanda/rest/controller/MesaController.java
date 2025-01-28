package br.com.boteco.comanda.rest.controller;

import br.com.boteco.comanda.rest.dto.MesaDTO;
import br.com.boteco.comanda.service.MesaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mesas")
public class MesaController {
    private final MesaService mesaService;

    public MesaController(MesaService mesaService) {
        this.mesaService = mesaService;
    }

    @GetMapping
    public ResponseEntity<List<MesaDTO>> listarTodas() {
        return ResponseEntity.ok(mesaService.listarTodas());
    }
}