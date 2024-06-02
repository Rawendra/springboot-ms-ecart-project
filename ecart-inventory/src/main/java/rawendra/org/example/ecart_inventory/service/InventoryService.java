package rawendra.org.example.ecart_inventory.service;

import rawendra.org.example.ecart_inventory.dto.InventoryCheckDto;
import rawendra.org.example.ecart_inventory.dto.InventoryDto;

import java.util.List;

public interface InventoryService {
  void addInventoryDetails(InventoryDto inventoryDto);

  InventoryDto getInventoryDetails(String id);

  List<InventoryDto> getAllInventoryDetails();

  InventoryCheckDto getInventoryStatus(InventoryCheckDto inventoryCheckDto);
}
