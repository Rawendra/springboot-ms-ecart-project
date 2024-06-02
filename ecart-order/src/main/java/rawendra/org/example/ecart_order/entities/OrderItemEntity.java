package rawendra.org.example.ecart_order.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "order_items_tbl")
public class OrderItemEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long orderNumber;
  private String orderItemId;
  private String orderItemName;
  private BigDecimal cost;
  private Long quantity;

}
