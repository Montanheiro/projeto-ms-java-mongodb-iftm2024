package com.montanha.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private String id;

    @NotBlank(message = "O identificador do produto é obrigatório")
    private String productIdentifier;

    @NotBlank(message = "O nome do produto é obrigatório")
    private String nome;

    private String descricao;

    @NotNull(message = "O preço do produto deve ser informado")
    @Positive(message = "O preço do produto deve ser positivo")
    private Double preco;

    @NotNull(message = "A categoria do produto deve ser informada")
    private CategoryDTO category;

}
