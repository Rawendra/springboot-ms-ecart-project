package rawendra.org.example.ecart_order.service;

import rawendra.org.example.ecart_order.dto.OrderDto;

public interface OrderService {
  public void placeOrder(OrderDto orderDto);

  public OrderDto getOrderDetails(Long id);
}
