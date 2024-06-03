package rawendra.org.example.ecart_inventory.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import rawendra.org.example.ecart_inventory.dto.InventoryCheckDto;
import rawendra.org.example.ecart_inventory.dto.InventoryDto;
import rawendra.org.example.ecart_inventory.service.InventoryService;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

  private final InventoryService inventoryService;

  @PutMapping
  public void updateInventoryDetails() {

  }

  @PostMapping("/getInventoryStatus")
  public InventoryCheckDto getInventoryStatus(@RequestBody InventoryCheckDto inventoryCheckDto) {
    System.out.println("inventoryCheckDto"+inventoryCheckDto.toString());
    return inventoryService.getInventoryStatus(inventoryCheckDto);
  }

  @PostMapping
  public void addInventoryDetails(@RequestBody InventoryDto inventoryDto) {

    inventoryService.addInventoryDetails(inventoryDto);

  }

  @GetMapping("/{id}")
  public InventoryDto getInventoryDetails(@PathVariable String id) {
    return inventoryService.getInventoryDetails(id);
  }

  @GetMapping("")
  public List<InventoryDto> getInventoryDetails() {
    return inventoryService.getAllInventoryDetails();
  }


}
