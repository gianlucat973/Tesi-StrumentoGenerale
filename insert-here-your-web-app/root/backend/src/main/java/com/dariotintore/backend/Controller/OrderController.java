package com.dariotintore.backend.Controller;

import java.util.List;
import java.util.Optional;


import com.dariotintore.backend.Entity.Order;
import com.dariotintore.backend.Service.OrderService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping(value = "/{id}")
    public Optional<Order> getBookById(@PathVariable Long id) {
        return orderService.findOrderById(id);
    }

    @PostMapping(value = "/")
    public ResponseEntity<JSONObject> makeOrder(@RequestBody JSONObject body) {
        return orderService.makeOrder(body);
    }

    @PostMapping(value = "/getOrderPerEmail")
    public ResponseEntity<JSONObject> getOrderPerEmail(@RequestBody JSONObject body) {
        return orderService.getOrderPerEmail(body);
    }

}
