package rawendra.org.example.ecart_inventory.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rawendra.org.example.ecart_inventory.dto.InventoryCheckDto;
import rawendra.org.example.ecart_inventory.dto.InventoryDto;
import rawendra.org.example.ecart_inventory.entities.InventoryEntity;
import rawendra.org.example.ecart_inventory.repository.InventoryRepository;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

  private final InventoryRepository inventoryRepository;


  @Override
  public void addInventoryDetails(InventoryDto inventoryDto) {
    InventoryEntity inventoryEntity = InventoryEntity.builder()
            .inventoryProductCode(inventoryDto.getInventoryProductCode())
            .quantity(inventoryDto.getQuantity()).build();
    inventoryRepository.save(inventoryEntity);
  }

  @Override
  public InventoryDto getInventoryDetails(String id) {
    Optional<InventoryEntity> inventoryEntityOptional = inventoryRepository.findById(id);

    if (inventoryEntityOptional.isPresent()) {

      InventoryEntity entity = inventoryEntityOptional.get();
      return InventoryDto.builder().
              inventoryProductCode(entity.getInventoryProductCode())
              .quantity(entity.getQuantity()).
              build();
    }

    return null;
  }

  @Override
  public List<InventoryDto> getAllInventoryDetails() {
    return inventoryRepository.findAll().stream().map(entity -> InventoryDto.builder()
            .inventoryProductCode(entity.getInventoryProductCode())
            .quantity(entity.getQuantity())
            .build()
    ).toList();
  }

  @Override
  public InventoryCheckDto getInventoryStatus(InventoryCheckDto inventoryCheckDto) {

    boolean allItemsPresent;
    boolean anyItemsPresent = false;
    int itemQuantityPresent=0;
    List<InventoryDto> inventoryDtoList = inventoryCheckDto.getInventoryDtoList();

    for (InventoryDto inventoryDto : inventoryDtoList) {

      Optional<InventoryEntity> entity = inventoryRepository.findById(inventoryDto.getInventoryProductCode());
      if (entity.isPresent()) {
        InventoryEntity inventoryEntity = entity.get();
        boolean isAvailable =inventoryEntity.getQuantity() - inventoryDto.getQuantity() > 0;
        inventoryDto.setIsAvailable(isAvailable);
        if(isAvailable){
          anyItemsPresent=true;
          itemQuantityPresent++;
        }
      }
    }

    allItemsPresent=  itemQuantityPresent==inventoryDtoList.size();

    inventoryCheckDto.setNoneAvailable(!anyItemsPresent);
    inventoryCheckDto.setAllItemsAvailable(allItemsPresent);
    return inventoryCheckDto;

  }
}
