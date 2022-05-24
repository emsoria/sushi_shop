package com.sushishop.sushishop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
public class Sushi {
    @Id
    @Column
    private final int id;
    @Column
    private String name;
    @Column
    private int time;

    //defining the ids so they are always the same for a specific sushi
    public Sushi (String name, int time)
    {
        if(name == "California Roll")
        {
            this.id=1;
            this.name=name;
            this.time=time;
        }
        else if(name == "Kamikaze Roll")
        {
            this.id=2;
            this.name=name;
            this.time=time;
        }
        else if(name == "Dragon Eye")
        {
            this.id=3;
            this.name=name;
            this.time=time;
        }
    }

    public String getName()
    {
        return this.name;
    }

    public int getTime()
    {
        return this.time;
    }

    public int getId()
    {
        return this.id;
    }

}
