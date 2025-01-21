package lucashumberto.shopping_api.converter;

import java.util.List;
import java.util.stream.Collectors;

import lucashumberto.shopping_api.models.Item;
import lucashumberto.shopping_api.models.Shopping;
import com.montanha.dto.ItemDTO;
import com.montanha.dto.ShoppingDTO;

public class DTOConverter {

        public static ShoppingDTO fromModel(Shopping shopping) {
        List<ItemDTO> itemsDTO = shopping.getItems().stream()
                .map(DTOConverter::fromModel)
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
                .map(DTOConverter::toModel)
                .collect(Collectors.toList());
        return new Shopping(
                shoppingDTO.getId(),
                shoppingDTO.getUserIdentifier(),
                shoppingDTO.getDate(),
                items,
                shoppingDTO.getTotal());
    }

    public static ItemDTO fromModel(Item item) {
        return new ItemDTO(item.getProductIdentifier(), item.getPrice());
    }

    public static Item toModel(ItemDTO itemDTO) {
        return new Item(itemDTO.getProductIdentifier(), itemDTO.getPrice());
    }

}
