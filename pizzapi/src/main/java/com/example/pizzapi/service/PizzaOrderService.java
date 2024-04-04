package com.example.pizzapi.service;

import com.example.pizzapi.model.PizzaOrder;
import com.example.pizzapi.repository.PizzaOrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@AllArgsConstructor
public class PizzaOrderService implements IPizzaOrder{
    private PizzaOrderRepository pizzaOrderRepository;

    @Override
    public List<PizzaOrder> getAllOrders() {
        return pizzaOrderRepository.findAll();
    }

    @Override
    public PizzaOrder createOrder(PizzaOrder pizzaOrder) {
        return pizzaOrderRepository.save(pizzaOrder);
    }
}
