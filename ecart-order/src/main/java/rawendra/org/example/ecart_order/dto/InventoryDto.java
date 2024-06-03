package rawendra.org.example.ecart_order.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class InventoryDto implements Serializable {

  private String inventoryProductCode;
  private Long quantity;
  private Boolean isAvailable;

}
