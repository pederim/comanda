package br.com.boteco.comanda.rest.dto;

import br.com.boteco.comanda.model.FormaPagamentoModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
public class FormaPagamentoDTO {

    @Column(name = "idFormaPagamento")
    private Long idFormaPagamento;

    @Column(name = "nome", length = 255, nullable = false, unique = true)
    private String nome;

    @Column(name = "descricao", length = 255)
    private String descricao;

    public FormaPagamentoModel toModel() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this, FormaPagamentoModel.class);
    }
}
