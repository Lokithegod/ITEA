package com.gmail.kss95kss.dto.model;

public class Product {

    private int id;
    private  String name;
    private double price;
    private String text;

    public Product(int id, String name, double price, String text) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.text = text;
    }

    public Product()
    {}

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

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", text='" + text + '\'' +
                '}';
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
