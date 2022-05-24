package com.sushishop.sushishop.entity;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonRootName;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Builder;
import lombok.Data;

@Table
@Entity
@Data
@Builder
@JsonRootName("order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int id;
    @Column
    private int statusId;
    @Column
    private int sushiId;
    @Column
    @CreationTimestamp
    private LocalTime createdAt;
    //the following fields seem to make it easier in java but I am not sure that it does in spring boot
    private Sushi sushi;
    private Status status;


    public Order(Sushi sushi)
    {
        this.statusId=new Status("created").getId();
        this.sushiId=sushi.getId();
        this.sushi=sushi;
        this.status=new Status("created");
    }

    public void setStatus_id(int id)
    {
        this.statusId=id;
    }

    public LocalTime getTime()
    {
        return this.createdAt;
    }

    
}
