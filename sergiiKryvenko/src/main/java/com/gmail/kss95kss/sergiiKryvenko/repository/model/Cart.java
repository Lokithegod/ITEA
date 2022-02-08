package com.gmail.kss95kss.sergiiKryvenko.repository.model;

import javax.persistence.*;
import java.beans.ConstructorProperties;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(foreignKey = @ForeignKey(name = "C6"))
    @Column(name = "client_id")
    private Integer clientID;
    @JoinColumn(foreignKey = @ForeignKey(name = "C5"))
    @Column(name = "product_id")
    private Integer product_id;
    @Column(name = "count")
    private Integer count;


    public Cart(Integer id, Integer clientID, Integer product_id, Integer count) {
        this.id = id;
        this.clientID = clientID;
        this.product_id = product_id;
        this.count = count;
    }

    public Cart() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClientID() {
        return clientID;
    }

    public void setClientID(Integer clientID) {
        this.clientID = clientID;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", clientID=" + clientID +
                ", product_id=" + product_id +
                ", count=" + count +
                '}';
    }
}
