package rawendra.org.ecart.product_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProductDtoRequest {

  private List<ProductDto> productDtoList;
 // private List<String> productIdList;
}
