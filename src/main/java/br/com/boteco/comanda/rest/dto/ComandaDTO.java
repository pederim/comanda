package br.com.boteco.comanda.rest.dto;

import br.com.boteco.comanda.model.ComandaModel;
import br.com.boteco.comanda.model.FormaPagamentoModel;
import br.com.boteco.comanda.model.GarcomModel;
import br.com.boteco.comanda.model.MesaModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;

public class ComandaDTO {

    @Column(name = "idComanda")
    private Long idComanda;

    @Column(name = "dataHoraAbertura", nullable = false)
    private LocalDateTime dataHoraAbertura;

    @Column(name = "dataHoraFechamento")
    private LocalDateTime dataHoraFechamento;

    @Column(name = "valorTotalComanda")
    private Float valorTotalComanda;

    @Column(name = "valorGorjeta")
    private Float valorGorjeta;

    @Column(name = "status", length = 255)
    private String status;

    @JoinColumn(name = "idMesa", nullable = false)
    private MesaModel mesa;

    @JoinColumn(name = "idGarcom", nullable = false)
    private GarcomModel garcom;

    @JoinColumn(name = "idFormaPagamento")
    private FormaPagamentoModel formaPagamento;

    public ComandaModel toModel(){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this, ComandaModel.class);
    }
}
