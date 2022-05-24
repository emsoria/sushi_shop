package com.sushishop.sushishop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sushishop.sushishop.entity.Order;
import com.sushishop.sushishop.repository.OrderRepository;
import com.sushishop.sushishop.service.OrderService;

@RestController
@RequestMapping(path="/api/orders")
public class OrderController
{
    @Autowired
    OrderService orderService;

    @Autowired
    OrderRepository orderRespository;

    @GetMapping("/api/orders/status")
    public ResponseEntity<List<Order>> getAllOrders()
    {
        try
        {
            List<Order> list = (List) orderRespository.findAll();
            if(list.isEmpty() || list.size()==0)
            {
                return new ResponseEntity<List<Order>>(HttpStatus.NO_CONTENT);
            }
            else
            {
                return new ResponseEntity<List<Order>>(list, HttpStatus.OK);
            }
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    /*
    this previous code is wrong 
    It should get all the orders and order them by statusId then return the list
    */


    @DeleteMapping("/api/orders/{order_id}")
    public ResponseEntity<HttpStatus> deleteOrder(@PathVariable("id") int id)
    {
        try
        {
            Optional<Order> order = orderRespository.findById(id);
            if(order.isPresent())
            {
                orderRespository.delete(order.get());
            }
            return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
        }
        catch (Exception e)
        {
            return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    /*
    this previous code is wrong
    it should return the 'code' and 'msg'
    */

    @PostMapping("api/orders")
    public ResponseEntity<Order> addOrder(@RequestBody Order order)
    {
        try
        {
            return new ResponseEntity<Order>(orderRespository.save(order), HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    /*
    this code could work but the implementation behind is not done
    as the incoming json is for a sushi, an implementation should be made to read the sushi and turn
    it into an order
    in addition it would be ideal to check if the json file is correctly formatted and to send out an 
    error message when it is not
    */

    @PutMapping("/api/orders/{order_id}/pause")
    public ResponseEntity<Order> updateOrder(@RequestBody Order order)
    {
        try
        {
            return new ResponseEntity<Order>(orderRespository.save(order), HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    /*
    this implementation is also wrong it should return the 'code' and 'message'
    */
}