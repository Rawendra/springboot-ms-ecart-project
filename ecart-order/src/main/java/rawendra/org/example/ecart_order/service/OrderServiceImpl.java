package rawendra.org.example.ecart_order.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rawendra.org.example.ecart_order.constants.ORDER_STATUS;
import rawendra.org.example.ecart_order.dto.OrderDto;
import rawendra.org.example.ecart_order.dto.OrderItemDto;
import rawendra.org.example.ecart_order.entities.OrderEntity;
import rawendra.org.example.ecart_order.entities.OrderItemEntity;
import rawendra.org.example.ecart_order.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

  private final OrderRepository orderRepository;

  @Override
  public OrderDto getOrderDetails(Long id) {
    Optional<OrderEntity> orderEntityOptional = orderRepository.findById(id);
    if (orderEntityOptional.isPresent()) {
      OrderEntity orderEntity = orderEntityOptional.get();
      List<OrderItemDto> orderItemDtoList = getOrderItemDtoFromEntity(orderEntity.getOrderItemEntityList());
      return getOrderDtoFromEntity(orderEntity, orderItemDtoList);
    }
    return null;
  }

  private OrderDto getOrderDtoFromEntity(OrderEntity orderEntity, List<OrderItemDto> orderItemDtoList) {

    return  OrderDto.builder()
            .orderItemEntityList(orderItemDtoList)
            .orderId(orderEntity.getOrderId())
            .totalCost(orderEntity.getTotalCost())
            .orderStatus(orderEntity.getOrderStatus())
            .orderPlacedBy(orderEntity.getOrderPlacedBy())
            .build();


  }

  private List<OrderItemDto> getOrderItemDtoFromEntity(List<OrderItemEntity> orderItemEntityList) {
    return orderItemEntityList.stream().map(orderItemEntity -> {
      return OrderItemDto.builder()
              .orderItemId(orderItemEntity.getOrderItemId())
              .orderItemName(orderItemEntity.getOrderItemName())
              .cost(orderItemEntity.getCost())
              .quantity(orderItemEntity.getQuantity())
              .build();
    }).toList();
  }


  @Override
  @Transactional
  public void placeOrder(OrderDto orderDto) {
    List<OrderItemEntity> orderItemEntityList = getOrderItemEntityListFromDto(orderDto.getOrderItemEntityList());
    OrderEntity orderEntity = getOrderEntityFromOrderDto(orderDto, orderItemEntityList);
    orderRepository.save(orderEntity);
  }

  private List<OrderItemEntity> getOrderItemEntityListFromDto(List<OrderItemDto> orderItemEntityList) {
    return orderItemEntityList.stream().map(item -> OrderItemEntity.builder()
            .orderItemId(item.getOrderItemId())
            .cost(item.getCost())
            .quantity(item.getQuantity())
            .orderItemName(item.getOrderItemName())
            .build()
    ).toList();
  }

  private OrderEntity getOrderEntityFromOrderDto(OrderDto orderDto, List<OrderItemEntity> orderItemEntityList) {
    return OrderEntity.builder()

            .orderPlacedBy(orderDto.getOrderPlacedBy())
            .orderItemEntityList(orderItemEntityList)
            .orderStatus(ORDER_STATUS.PENDING)
            .totalCost(orderDto.getTotalCost())
            .build();
  }


}
