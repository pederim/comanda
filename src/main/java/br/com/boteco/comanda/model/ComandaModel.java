package br.com.boteco.comanda.model;

import br.com.boteco.comanda.rest.dto.ComandaDTO;
import br.com.boteco.comanda.rest.dto.GarcomDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "comanda")
public class ComandaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idComanda")
    private Long idComanda;

    @NotNull(message = "Data e hora de abertura não podem ser nulos.")
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

    @ManyToOne
    @JoinColumn(name = "idMesa", nullable = false)
    private MesaModel mesa;

    @ManyToOne
    @JoinColumn(name = "idGarcom", nullable = false)
    private GarcomModel garcom;

    @ManyToOne
    @JoinColumn(name = "idFormaPagamento")
    private FormaPagamentoModel formaPagamento;

    public ComandaDTO toDTO(){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this, ComandaDTO.class);
    }
}
