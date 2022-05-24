package com.sushishop.sushishop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Status 
{
    @Id
    @Column
    private int id;
    @Column
    private String name;
   // private int time_spent;

   //Definind each status to a specific id
    public Status(String name)
    {
        if(name == "created")
        {
            this.id=1;
            this.name=name;
        }
        else if(name == "in-progress")
        {
            this.id=2;
            this.name=name;
        }
        else if(name == "paused")
        {
            this.id=3;
            this.name=name;
        }
        else if(name == "finished")
        {
            this.id=4;
            this.name=name;
        }
        else if(name == "cancelled")
        {
            this.id=5;
            this.name=name;
        }
    }

    public int getId()
    {
        return this.id;
    }

    public String Update(int id)
    {
        if(id == 1)
        {
            this.id=1;
            this.name="created";
            return this.name;
        }
        else if(id ==2)
        {
            this.id=2;
            this.name="in-progress";
            return this.name;
        }
        else if(id ==3)
        {
            this.id=3;
            this.name="paused";
            return this.name;
        }
        else if(id ==4)
        {
            this.id=4;
            this.name="finished";
            return this.name;
        }
        else if(id ==5)
        {
            this.id=5;
            this.name="cancelled";
            return this.name;
        }
        return this.name;
    }
}
