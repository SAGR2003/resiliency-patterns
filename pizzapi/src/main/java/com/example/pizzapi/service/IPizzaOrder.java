package com.example.pizzapi.service;

import com.example.pizzapi.model.PizzaOrder;

import java.util.List;

public interface IPizzaOrder {
    List<PizzaOrder> getAllOrders();
    PizzaOrder createOrder(PizzaOrder order);
}
