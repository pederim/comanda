package br.com.boteco.comanda.model;

import br.com.boteco.comanda.rest.dto.ProdutoDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "produto")
public class ProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProduto")
    private Long idProduto;

    @NotNull(message = "Nome do produto não pode ser nulo.")
    @NotBlank(message = "Nome do produto não pode ser em branco.")
    @Column(name = "nome", length = 255, nullable = false, unique = true)
    private String nome;

    @Column(name = "descricao", length = 255)
    private String descricao;

    @NotNull(message = "Preço do produto não pode ser nulo.")
    @Column(name = "preco", nullable = false)
    private Float preco;

    @NotNull(message = "Status do produto não pode ser nulo.")
    @Column(name = "status", length = 255, nullable = false)
    private String status;

    public ProdutoDTO toDTO() {
        return new ProdutoDTO(this.idProduto, this.nome, this.descricao, this.preco, this.status);
    }


}
