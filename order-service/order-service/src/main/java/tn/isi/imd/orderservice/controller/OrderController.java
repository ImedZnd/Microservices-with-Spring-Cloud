package tn.isi.imd.orderservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.isi.imd.orderservice.client.InventoryClient;
import tn.isi.imd.orderservice.dto.OrderDto;
import tn.isi.imd.orderservice.model.Order;
import tn.isi.imd.orderservice.repository.OrderRepository;

import java.util.UUID;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;

    @PostMapping
    public  String placeOrder(@PathVariable OrderDto orderDto){
        boolean allProductsInStock = orderDto.getOrderLineItemsList().stream()
                .allMatch(orderLineItems -> inventoryClient.checkStock(orderLineItems.getSkuCode()));
        System.out.println("place order called");
        if(allProductsInStock){
            Order order = new Order();
            order.setOrderLineItems(orderDto.getOrderLineItemsList());
            order.setOrderNumber(UUID.randomUUID().toString());
            orderRepository.save(order);
            return "Order Placed Successfully";

        }else{
            return  "Order fail ,One of the Products is not in stack";
        }
    }
}
