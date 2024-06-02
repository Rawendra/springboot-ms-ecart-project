package rawendra.org.example.ecart_order.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import rawendra.org.example.ecart_order.dto.OrderDto;
import rawendra.org.example.ecart_order.service.OrderService;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

  private final OrderService orderService;

  @PostMapping("")
  public void placeOrder(@RequestBody OrderDto orderDto){

    orderService.placeOrder(orderDto);

  }

  @GetMapping("/{id}")
  public OrderDto getOrderDetails(@PathVariable  Long id){
    return orderService.getOrderDetails(id);

  }
}
