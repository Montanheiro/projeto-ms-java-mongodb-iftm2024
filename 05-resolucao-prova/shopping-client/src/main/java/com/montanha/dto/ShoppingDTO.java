package com.montanha.dto;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingDTO {

    private String id;

    @NotBlank(message = "O identificador do usuário é obrigatório.")
    private String userIdentifier;

    @NotNull(message = "A data da compra deve ser informada.")
    private LocalDateTime date;

    @NotNull(message = "A lista de itens não pode ser vazia.")
    private List<ItemDTO> items;

    @NotNull(message = "O total da compra deve ser informado.")
    @Positive(message = "O total da compra deve ser um valor positivo.")
    private Double total;

}
