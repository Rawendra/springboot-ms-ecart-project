package rawendra.org.example.ecart_inventory.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class InventoryDto {

  private String inventoryProductCode;
  private Long quantity;
  private Boolean isAvailable;

}
