package rawendra.org.example.ecart_order.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItemDto {
  private String orderItemId;
  private String orderItemName;
  private BigDecimal cost;
  private Long quantity;


}
