package com.sin.sb1031.shipments;

import javax.persistence.*;

@Entity
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long orderId;

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    private String productName;
    private int quantity;
    private double price;
    private String status; // 주문 상태 (예: "주문 접수", "배송 중", "배송 완료")
//    private String formattedPrice;

    @Transient
    private double totalPrice;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public double getTotalPrice() {
        return totalPrice; // 총합 가격 계산
    }
    private void updateTotalPrice() {
        this.totalPrice = this.price * this.quantity; // 총합 가격 계산
    }

}
