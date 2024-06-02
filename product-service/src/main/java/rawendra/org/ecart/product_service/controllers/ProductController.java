package rawendra.org.ecart.product_service.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import rawendra.org.ecart.product_service.dto.ProductDto;
import rawendra.org.ecart.product_service.dto.ProductDtoRequest;
import rawendra.org.ecart.product_service.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {



 private final ProductService productService;

@PostMapping("/addProductList")
@ResponseStatus(HttpStatus.CREATED)
  public void createProduct(@RequestBody ProductDtoRequest productDtoRequest){

  productService.addProductList(productDtoRequest);

  }

  @PutMapping("/updateProductList")
  @ResponseStatus(HttpStatus.CREATED)
  public void updateProducts(@RequestBody ProductDtoRequest productDtoRequest){

    productService.updateProductList(productDtoRequest);

  }

  @GetMapping("")
  public  ProductDtoRequest getAllProducts(){
    return productService.getAllProducts();
  }

}
