package com.example.pizzapi.controller;

import com.example.pizzapi.model.PizzaOrder;
import com.example.pizzapi.service.IPizzaOrder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizzapi")
@AllArgsConstructor
public class PizzaOrderController {
    private final IPizzaOrder pizzaService;

    @GetMapping("")
    public ResponseEntity<?> getAllOrders() {
        List<PizzaOrder> orders = pizzaService.getAllOrders();
        if (orders.size() == 1 && orders.get(0).getCustomerName().equals("CircuitOpen")) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Open circuit");
        } else {
            return ResponseEntity.ok(orders);
        }
    }

    @PostMapping("")
    public PizzaOrder createOrder(@RequestBody PizzaOrder pizzaOrder) {
        return pizzaService.createOrder(pizzaOrder);
    }

}
