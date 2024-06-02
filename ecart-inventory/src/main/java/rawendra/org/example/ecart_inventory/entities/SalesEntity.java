package rawendra.org.example.ecart_inventory.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "sales_record_tbl")

public class SalesEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long saleRecordId;
  @Temporal(TemporalType.DATE)
  private Date date;
  private BigDecimal totalCost;
}
