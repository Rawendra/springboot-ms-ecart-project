package rawendra.org.example.ecart_inventory.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "inventory_details_tbl")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class InventoryEntity {

  @Id
  private String inventoryProductCode;
  private Long quantity;

}
