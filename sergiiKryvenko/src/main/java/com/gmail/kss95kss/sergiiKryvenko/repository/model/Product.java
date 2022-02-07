package com.gmail.kss95kss.sergiiKryvenko.repository.model;

import javax.persistence.*;


@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column(name = "name")
    private  String name;
    @Column(name="price")
    private double price;
    @Column(name="description")
    private String text;


    public Product() {
    }

    public Product(String name, double price, String text) {

    }

    public Product(int id, String name, double price, String text) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", text='" + text + '\'' +
                '}';
    }
}
