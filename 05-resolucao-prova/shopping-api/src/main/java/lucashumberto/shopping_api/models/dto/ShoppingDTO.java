package lucashumberto.shopping_api.models.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lucashumberto.shopping_api.models.Item;
import lucashumberto.shopping_api.models.Shopping;

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

    public static ShoppingDTO fromModel(Shopping shopping) {
        List<ItemDTO> itemsDTO = shopping.getItems().stream()
                .map(ItemDTO::fromModel)
                .collect(Collectors.toList());
        return new ShoppingDTO(
                shopping.getId(),
                shopping.getUserIdentifier(),
                shopping.getDate(),
                itemsDTO,
                shopping.getTotal());
    }

    public static Shopping toModel(ShoppingDTO shoppingDTO) {
        List<Item> items = shoppingDTO.getItems().stream()
                .map(ItemDTO::toModel)
                .collect(Collectors.toList());
        return new Shopping(
                shoppingDTO.getId(),
                shoppingDTO.getUserIdentifier(),
                shoppingDTO.getDate(),
                items,
                shoppingDTO.getTotal());
    }

}
