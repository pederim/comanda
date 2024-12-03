package br.com.boteco.comanda.rest.dto;

import br.com.boteco.comanda.model.MesaModel;
import jakarta.persistence.Column;
import org.modelmapper.ModelMapper;

public class MesaDTO {

    @Column(name = "idMesa")
    private Long idMesa;

    @Column(name = "numero", nullable = false)
    private Integer numero;

    @Column(name = "status", length = 255)
    private String status;

    public MesaModel toModel() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this, MesaModel.class);
    }
}
