package rawendra.org.ecart.product_service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import rawendra.org.ecart.product_service.entities.ProductEntity;

public interface ProductRepository extends MongoRepository<ProductEntity, String> {

}
