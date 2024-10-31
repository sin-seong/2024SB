package com.sin.sb1031.order;


import com.sin.sb1031.event.CustomEventPublisher;
import com.sin.sb1031.shipments.Shipment;
import com.sin.sb1031.shipments.ShipmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/orders")
@Slf4j
@RequiredArgsConstructor
public class OrderController {

    private final CustomEventPublisher customEventPublisher;
    private final OrderService orderService;
    private final ApplicationEventPublisher eventPublisher;
    private final ShipmentService shipmentService;

    @PostMapping
    @ResponseBody
    public Order createOrder(@RequestBody Order order) {

        return orderService.saveOrder(order);
    }

    @GetMapping
    public String getAllOrders(Model model) {
        List<Order> orders = orderService.getAllOrders();
        model.addAttribute("orders", orders);
        return "/orders/orderList";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Optional<Order> getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }

    @GetMapping("/new")
    public String newOrderForm(Model model) {
        model.addAttribute("order", new Order());
        return "/orders/orderForm";
    }

    @PostMapping("/save")
    public String saveOrder(@ModelAttribute Order order) {
        log.info("Order created: " + order);
        customEventPublisher.doStuffAndPublish(order.toString());

        Order savedOrder = orderService.saveOrder(order);

        Shipment shipment = new Shipment();
        shipment.setOrderId(savedOrder.getId()); // 저장된 주문 ID 설정
        shipment.setProductName(order.getProductName()); // 주문의 제품 이름 설정
        shipment.setQuantity(order.getQuantity()); // 주문의 수량 설정
        shipment.setPrice(order.getPrice()); // 주문의 가격 설정
        shipment.setStatus("주문접수");
        shipmentService.saveShipment(shipment);
        return "redirect:/orders";
    }

    @GetMapping("/delete/{id}")
    public String deleteOrder1(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return "redirect:/orders";
    }
}