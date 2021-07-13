package com.mxh.entity;

import java.util.Date;

public class Product {
    private String name;

    private Integer id;

    private Double price;

    private Date bir;

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", price=" + price +
                ", bir=" + bir +
                '}';
    }

    public Product() {
    }

    public Product(String name, Integer id, Double price, Date bir) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.bir = bir;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getBir() {
        return bir;
    }

    public void setBir(Date bir) {
        this.bir = bir;
    }
}
