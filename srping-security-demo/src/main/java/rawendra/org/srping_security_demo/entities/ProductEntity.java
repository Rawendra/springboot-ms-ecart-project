package rawendra.org.srping_security_demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_table")

public class ProductEntity {
  @Id
  private Long id;
  private String productName;
  private BigDecimal productCost;

}
