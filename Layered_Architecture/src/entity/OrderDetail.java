package entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class OrderDetail {
    @Id
    String orderDetailId;
    int qty;
    BigDecimal unitPrice;
    @ManyToOne
    @JoinColumn(name = "oid",referencedColumnName = "oid")
    Orders order;
    @OneToOne
    @JoinColumn(name = "itemCode",referencedColumnName = "code")
    Item item;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public OrderDetail() {
    }

    public OrderDetail(Orders order, Item item, BigDecimal unitPrice, int qty) {
        this.order = order;
        this.item = item;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public String getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(String orderDetailId) {
        this.orderDetailId = orderDetailId;
    }


    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }
}
