package br.com.boteco.comanda.rest.dto;

import br.com.boteco.comanda.model.ComandaModel;
import br.com.boteco.comanda.model.ConsumoModel;
import br.com.boteco.comanda.model.ProdutoModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;

public class ConsumoDTO {

    @Column(name = "idConsumo")
    private Long idConsumo;

    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;

    @Column(name = "dataHoraConsumo", nullable = false)
    private LocalDateTime dataHoraConsumo;

    @Column(name = "precoUnitarioVendido", nullable = false)
    private Float precoUnitarioVendido;

    @Column(name = "precoTotal", nullable = false)
    private Float precoTotal;

    @JoinColumn(name = "idComanda", nullable = false)
    private ComandaModel comanda;

    @JoinColumn(name = "idProduto", nullable = false)
    private ProdutoModel produto;

    public ConsumoModel toModel(){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this, ConsumoModel.class);
    }
}
