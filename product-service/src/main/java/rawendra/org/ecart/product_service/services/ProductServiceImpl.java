package rawendra.org.ecart.product_service.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rawendra.org.ecart.product_service.dto.ProductDto;
import rawendra.org.ecart.product_service.dto.ProductDtoRequest;
import rawendra.org.ecart.product_service.entities.ProductEntity;
import rawendra.org.ecart.product_service.repository.ProductRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;

  @Override
  public void addProductList(ProductDtoRequest productDtoRequest) {

    List<ProductDto> productDtoList = productDtoRequest.getProductDtoList();

    List<ProductEntity> productEntityList = getProductEntites(productDtoList);

    productRepository.saveAll(productEntityList);

  }

  @Transactional
  @Override
  public void updateProductList(ProductDtoRequest productDtoRequest) {

    List<ProductEntity> productEntityList = productDtoRequest.getProductDtoList().stream().map(productDto -> {


      Optional<ProductEntity> productEntityOptional = productRepository.findById(productDto.getId());
      if (productEntityOptional.isPresent()) {
        ProductEntity productEntity = productEntityOptional.get();
        productEntity.setDescription(productDto.getDescription());
        productEntity.setName(productDto.getName());
        productEntity.setPrice(productDto.getPrice());
        return productEntity;
      } else {
        return null;
      }


    }).filter(Objects::nonNull).toList();


    productRepository.saveAll(productEntityList);


  }

  @Override
  public ProductDtoRequest getAllProducts() {
    List<ProductEntity> productEntityList = productRepository.findAll();

    return ProductDtoRequest.builder().productDtoList(getProductDtoList(productEntityList)).build();
  }

  private List<ProductEntity> getProductEntites(List<ProductDto> productDtoList) {

    return productDtoList.stream().map(productDto ->
            ProductEntity.builder().price(productDto.getPrice())
                    .name(productDto.getName()).description(productDto.getDescription())
                    .build()
    ).toList();

  }

  private List<ProductDto> getProductDtoList(List<ProductEntity> productEntityList) {

    return productEntityList.stream().map(productEntity ->
            ProductDto.builder().price(productEntity.getPrice())
                    .name(productEntity.getName()).description(productEntity.getDescription()).id(productEntity.getId())
                    .build()
    ).toList();

  }


}
