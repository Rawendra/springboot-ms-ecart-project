package rawendra.org.example.ecart_order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rawendra.org.example.ecart_order.entities.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
