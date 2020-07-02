package com.example.accessdatamysql.model;

import javax.persistence.*;

@Entity
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Integer price;

    public Products(){}
    public Products(String name, Integer price){
        this.name = name;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }



    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPrice() {
        return price;
    }
}
