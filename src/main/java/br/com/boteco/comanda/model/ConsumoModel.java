package br.com.boteco.comanda.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "consumo")
public class ConsumoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idConsumo")
    private Long idConsumo;

    @NotNull(message = "Quantidade não pode ser nula.")
    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;

    @NotNull(message = "Data e hora do consumo não podem ser nulos.")
    @Column(name = "dataHoraConsumo", nullable = false)
    private LocalDateTime dataHoraConsumo;

    @NotNull(message = "Preço unitário não pode ser nulo.")
    @Column(name = "precoUnitarioVendido", nullable = false)
    private Float precoUnitarioVendido;

    @NotNull(message = "Preço total não pode ser nulo.")
    @Column(name = "precoTotal", nullable = false)
    private Float precoTotal;

    @ManyToOne
    @JoinColumn(name = "idComanda", nullable = false)
    private ComandaModel comanda;

    @ManyToOne
    @JoinColumn(name = "idProduto", nullable = false)
    private ProdutoModel produto;
}
