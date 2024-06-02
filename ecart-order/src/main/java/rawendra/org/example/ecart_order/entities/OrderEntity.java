package rawendra.org.example.ecart_order.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import rawendra.org.example.ecart_order.constants.ORDER_STATUS;

import java.math.BigDecimal;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "order_tbl")
public class OrderEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long orderId;
  private String orderPlacedBy;
  private BigDecimal totalCost;
  @Enumerated(EnumType.STRING)
  private ORDER_STATUS orderStatus;// PENDING APPROVED COMPLETED

  @OneToMany(cascade = CascadeType.ALL)
  private List<OrderItemEntity> orderItemEntityList;


}
