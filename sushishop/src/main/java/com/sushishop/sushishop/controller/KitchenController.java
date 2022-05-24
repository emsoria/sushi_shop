package com.sushishop.sushishop.controller;

import java.time.LocalTime;
import java.util.ArrayDeque;
import java.util.Queue;

import com.sushishop.sushishop.entity.Order;

import com.sushishop.sushishop.entity.Chef;

// Here is a simulation for 3 chefs that can each take 1 order at a time 
// The queue is to accomodate incoming orders while the chefs are busy
public class KitchenController {
    private Chef chef1;
    private Chef chef2;
    private Chef chef3;
    private Queue<Order> orders;

    public KitchenController()
    {
        chef1 = new Chef(1);
        chef2 = new Chef(2);
        chef3 = new Chef(3);
        orders = new ArrayDeque<Order>();
    }

    public void addOrder(Order order)
    {
        update(); //update first to see if any order has been completed etc
        //if the chef does not have an order currently
        if (!chef1.hasOrder())
        {
            chef1.setOrder(order, LocalTime.now());      //assign order to chef
            chef1.setHasOrder(true);
            order.setStatus_id(2);  //update status of order to 'in-progress'
        }
        else if (!chef2.hasOrder())
        {
            chef2.setOrder(order, LocalTime.now());
            chef2.setHasOrder(true);
            order.setStatus_id(2);
        }
        else if (!chef3.hasOrder())
        {
            chef3.setOrder(order, LocalTime.now());
            chef3.setHasOrder(true);
            order.setStatus_id(2);
        }
        else
        {
            //if all the chefs are occupied then add the order to the queue
            orders.add(order);
        }

    }

    //get time passed since order was taken by a chef
    public int timePassed(Chef chef)
    {
        LocalTime createdAt = chef.getTime();
        return LocalTime.now().getMinute() - createdAt.getMinute();
    }

    //checks if an order has been completed and if so the chef can take up another other
    public void update()
    {
        if (chef1.hasOrder())
        {
            int timePassed = timePassed(chef1);
            //need to change this so that it is compared to sushi time
            //meaning that it would need a GET method to fetch the time for the sushi id 
            if(timePassed <= 0) //if order is complete
            {
                chef1.getOrder().setStatus_id(4);  //update order status to 'finished'
                if(orders.size() != 0)      //if at least one order is in the queue
                {
                    Order o = orders.poll();    //dequeue
                    o.setStatus_id(2);      //update status to 'in-progress'
                    chef1.setOrder(o, LocalTime.now());
                    chef1.setHasOrder(true);
                }
                else
                {
                    chef1.setHasOrder(false); //chef available
                }
            }
        }
        if (chef2.hasOrder())
        {
            int timePassed = timePassed(chef2);
            if(timePassed <= 0)
            {
                chef2.getOrder().setStatus_id(4);
                if(orders.size() != 0)
                {
                    Order o = orders.poll();
                    o.setStatus_id(2);
                    chef2.setOrder(o, LocalTime.now());
                    chef2.setHasOrder(true);
                }
                else
                {
                    chef2.setHasOrder(false);
                }
            }
        }
        if (chef3.hasOrder())
        {
            int timePassed = timePassed(chef3);
            if(timePassed <= 0)
            {
                chef3.getOrder().setStatus_id(4);
                if(orders.size() != 0)
                {
                    Order o = orders.poll();
                    o.setStatus_id(2);
                    chef3.setOrder(o, LocalTime.now());
                    chef3.setHasOrder(true);
                }
                else
                {
                    chef3.setHasOrder(false);
                }
            }
        }
    }
}
