package rawendra.org.example.ecart_order.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InventoryCheckDto implements Serializable {
  private Boolean allItemsAvailable;
  private Boolean noneAvailable;
  private List<String> productIdList;
  private List<InventoryDto>  inventoryDtoList;
}

