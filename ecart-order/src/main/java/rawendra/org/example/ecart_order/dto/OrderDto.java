package rawendra.org.example.ecart_order.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import rawendra.org.example.ecart_order.constants.ORDER_STATUS;
import rawendra.org.example.ecart_order.entities.OrderItemEntity;

import java.math.BigDecimal;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDto {
  private Long orderId;
  private String orderPlacedBy;
  private BigDecimal totalCost;
  private ORDER_STATUS orderStatus;// PENDING APPROVED COMPLETED
  private List<OrderItemDto> orderItemEntityList;


}
