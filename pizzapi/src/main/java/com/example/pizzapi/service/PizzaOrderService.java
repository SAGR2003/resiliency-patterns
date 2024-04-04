package com.example.pizzapi.service;

import com.example.pizzapi.model.PizzaOrder;
import com.example.pizzapi.repository.PizzaOrderRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@AllArgsConstructor
public class PizzaOrderService implements IPizzaOrder{
    private final PizzaOrderRepository pizzaOrderRepository;
    private final AtomicInteger requestCounter = new AtomicInteger(0);

    @Override
    @CircuitBreaker(name = "pizzaDb", fallbackMethod = "fallbackGetAllOrders")
    public List<PizzaOrder> getAllOrders() {
        int requestNumber = requestCounter.incrementAndGet();
        if(requestNumber % 3 == 0){
            throw new RuntimeException("Request multiple of 3");
        }
        return pizzaOrderRepository.findAll();
    }

    @Override
    public PizzaOrder createOrder(PizzaOrder pizzaOrder) {
        return pizzaOrderRepository.save(pizzaOrder);
    }

    public List<PizzaOrder> fallbackGetAllOrders(Throwable t){
        return Collections.singletonList(new PizzaOrder(1L,"CircuitOpen", "", ""));
    }
}
