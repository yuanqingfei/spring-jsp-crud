package com.koneu.order;

import com.koneu.user.User;

import java.util.Date;

/**
 * Created by aaron on 16-7-16.
 */
public class Order {

    private String id;

    private Date orderDate;

    private Long orderBy;

    private Double subtotal;

    private OrderStatus orderStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Long getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(Long orderBy) {
        this.orderBy = orderBy;
    }

    @Override

    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", orderDate=" + orderDate +
                ", orderBy=" + orderBy +
                ", subTotal=" + subtotal +
                ", orderStatus=" + orderStatus +
                '}';
    }
}
