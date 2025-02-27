package lucashumberto.shopping_api.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.montanha.dto.ItemDTO;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @NotBlank(message = "O identificador do produto é obrigatório.")
    private String productIdentifier;

    @NotNull(message = "O preço do item deve ser informado.")
    @Positive(message = "O preço do item deve ser um valor positivo.")
    private Double price;

    public static Item fromDTO(ItemDTO itemDTO) {
        return new Item(itemDTO.getProductIdentifier(), itemDTO.getPrice());
    }
}