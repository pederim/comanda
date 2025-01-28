package br.com.boteco.comanda.rest.controller;

import br.com.boteco.comanda.model.GarcomModel;
import br.com.boteco.comanda.rest.dto.GarcomDTO;
import br.com.boteco.comanda.service.GarcomService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("garcom")
public class GarcomController {

    @Autowired
    private GarcomService garcomService;

    @GetMapping
    public ResponseEntity<List<GarcomDTO>> obterTodos(){
        List<GarcomDTO> garcomDTOS = garcomService.obterTodos();
        return ResponseEntity.ok(garcomDTOS);
    }

    @GetMapping("/obterGarcom")
    public ResponseEntity<GarcomDTO> obterGarcom(Long id) {
        GarcomDTO garcomDTO = garcomService.obterGarcom(id);
        return ResponseEntity.ok((GarcomDTO) garcomDTO);
    }

    @PostMapping
    public ResponseEntity<GarcomDTO> salvar(@RequestBody @Valid GarcomModel novoGarcom) {
        //GarcomDTO novoGarcomDTO = garcomService.salvar(novoGarcom);
        return ResponseEntity.ok(garcomService.salvar(novoGarcom));
    }

    @PutMapping
    public ResponseEntity<GarcomDTO> altualizar(@RequestBody @Valid GarcomModel garcomExistente) {
        // GarcomDTO garcomExistenteDTO = garcomService.atualizar(garcomExistente);
        return ResponseEntity.ok(garcomService.atualizar(garcomExistente));
    }

    @DeleteMapping
    public void deletar(@RequestBody @Valid GarcomModel garcomModel) {
        garcomService.deletar(garcomModel);
    }
}