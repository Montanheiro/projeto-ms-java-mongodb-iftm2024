package lucashumberto.shopping_api.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lucashumberto.shopping_api.models.Shopping;
import com.montanha.dto.ShoppingDTO;
import lucashumberto.shopping_api.converter.DTOConverter;
import lucashumberto.shopping_api.repositories.ShoppingRepository;

@Service
@RequiredArgsConstructor
public class ShoppingService {

    private final ShoppingRepository shoppingRepository;

    public List<ShoppingDTO> getAllShops() {
        return shoppingRepository.findAll().stream()
                .map(DTOConverter::fromModel)
                .collect(Collectors.toList());
    }

    public ShoppingDTO getShopById(String id) {
        Shopping shopping = shoppingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Compra não encontrada."));
        return DTOConverter.fromModel(shopping);
    }

    public ShoppingDTO saveShop(ShoppingDTO shoppingDTO) {
        Shopping shopping = DTOConverter.toModel(shoppingDTO);
        shopping.setDate(LocalDateTime.now());

        Double total = shoppingDTO.getItems()
                .stream()
                .map(x -> x.getPrice())
                .reduce((double) 0, Double::sum);
        shopping.setTotal(total);

        Shopping savedShopping = shoppingRepository.save(shopping);
        return DTOConverter.fromModel(savedShopping);
    }

    public List<ShoppingDTO> getShopsByUser(String userIdentifier) {
        return shoppingRepository.findByUserIdentifier(userIdentifier).stream()
                .map(DTOConverter::fromModel)
                .collect(Collectors.toList());
    }

    public List<ShoppingDTO> getShopsByDate(LocalDateTime startDate, LocalDateTime endDate) {
        return shoppingRepository.findByDateBetween(startDate, endDate).stream()
                .map(DTOConverter::fromModel)
                .collect(Collectors.toList());
    }

    public List<ShoppingDTO> getShopsByProductIdentifier(String productIdentifier) {
        return shoppingRepository.findByItemsProductIdentifier(productIdentifier).stream()
                .map(DTOConverter::fromModel)
                .collect(Collectors.toList());
    }

    public List<ShoppingDTO> getShopsByFilter(LocalDateTime startDate, LocalDateTime endDate, Double minValue) {
        return shoppingRepository.getShopsByFilter(startDate, endDate, minValue).stream()
                .map(DTOConverter::fromModel)
                .collect(Collectors.toList());
    }

    public List<ShoppingDTO> getReportByDate(LocalDateTime startDate, LocalDateTime endDate) {
        return shoppingRepository.getReportByDate(startDate, endDate).stream()
                .map(DTOConverter::fromModel)
                .collect(Collectors.toList());
    }
}