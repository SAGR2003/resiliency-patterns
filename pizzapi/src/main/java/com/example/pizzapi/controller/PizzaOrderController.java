package com.example.pizzapi.controller;

import com.example.pizzapi.model.PizzaOrder;
import com.example.pizzapi.service.IPizzaOrder;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizzapi")
@AllArgsConstructor
public class PizzaOrderController {
    private final IPizzaOrder pizzaService;

    @GetMapping("")
    public List<PizzaOrder> getAllOrders() {
        return pizzaService.getAllOrders();
    }

    @PostMapping("")
    public PizzaOrder createOrder(@RequestBody PizzaOrder pizzaOrder) {
        return pizzaService.createOrder(pizzaOrder);
    }

}
