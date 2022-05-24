package com.sushishop.sushishop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.sushishop.sushishop.entity.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer>
{
    
}