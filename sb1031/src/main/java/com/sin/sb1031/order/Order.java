package com.sin.sb1031.order;

import lombok.ToString;

import javax.persistence.*;

@Entity
@Table (name = "orders")
@ToString
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private int quantity;
    private double price;


    @Transient
    public double totalPrice;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

//    public String getFormattedPrice() {return formattedPrice;}
//
//    public void setFormattedPrice(String formattedPrice) {this.formattedPrice = formattedPrice;}
    public double getTotalPrice() {
        return totalPrice;
    }
    public void updateTotalPrice(){
        this.totalPrice = this.price * this.quantity;
    }
    public String getFormattedTotalPrice(){
        return String.format("%.2f원", totalPrice);
    }
}
