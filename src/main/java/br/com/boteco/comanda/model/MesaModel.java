package br.com.boteco.comanda.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mesa")
public class MesaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMesa")
    private Long idMesa;

    @NotNull(message = "Número da mesa não pode ser nulo.")
    @Column(name = "numero", nullable = false)
    private Integer numero;

    @Column(name = "status", length = 255)
    private String status;

}