package rawendra.org.example.ecart_inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import rawendra.org.example.ecart_inventory.entities.InventoryEntity;

import java.util.List;

public interface InventoryRepository extends JpaRepository<InventoryEntity,String> {

  @Query("select inventory from InventoryEntity inventory  where inventory.inventoryProductCode in  ( ?1 )  ")
  public List< InventoryEntity> getInventoryDetailsForIDs(String ids);
}
