package com.sushishop.sushishop.entity;

import java.time.LocalTime;

import org.hibernate.annotations.CreationTimestamp;

public class Chef {

    private final int num;
    private Order order;
    //the following field makes it easier to know if a chef is currently doing an order
    private boolean hasOrder;
    @CreationTimestamp
    private LocalTime createdAt;

    public Chef(int num, Order order)
    {
        this.num=num;
        this.order=order;
        this.hasOrder = true;
    }

    public Chef(int num)
    {
        this.num=num;
        this.hasOrder = false;
    }

    public Order getOrder()
    {
        return this.order;
    }

    public void setOrder(Order order, LocalTime newTime)
    {
        this.order=order;
        this.createdAt=newTime;
    }

    public LocalTime getTime()
    {
        return this.createdAt;
    }

    public boolean hasOrder()
    {
        return this.hasOrder;
    }

    public void setHasOrder(boolean b)
    {
        this.hasOrder=b;
    }
}

