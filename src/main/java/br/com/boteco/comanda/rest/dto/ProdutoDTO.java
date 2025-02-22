package br.com.boteco.comanda.rest.dto;

import br.com.boteco.comanda.model.ProdutoModel;
import jakarta.persistence.Column;
import org.modelmapper.ModelMapper;

public class ProdutoDTO {

    @Column(name = "idProduto")
    private Long idProduto;

    @Column(name = "nome", length = 255, nullable = false, unique = true)
    private String nome;

    @Column(name = "descricao", length = 255)
    private String descricao;

    @Column(name = "preco", nullable = false)
    private Float preco;

    @Column(name = "status", length = 255, nullable = false)
    private String status;

    public ProdutoDTO(Object o, String nenhumProdutoEncontrado, int i) {
    }

    public ProdutoModel toModel() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this, ProdutoModel.class);
    }

    public void setQuantidadeVendida(Long aLong) {
    }

    public ProdutoDTO(Long idProduto, String nome, String descricao, Float preco, String status) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.status = status;
    }


}
