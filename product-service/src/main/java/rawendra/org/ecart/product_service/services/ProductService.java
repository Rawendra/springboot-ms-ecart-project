package rawendra.org.ecart.product_service.services;

import rawendra.org.ecart.product_service.dto.ProductDto;
import rawendra.org.ecart.product_service.dto.ProductDtoRequest;

import java.util.List;

public interface ProductService {

  public void addProductList(ProductDtoRequest productDtoRequest);

  public void updateProductList(ProductDtoRequest productDtoRequest);

  public ProductDtoRequest  getAllProducts();
}
