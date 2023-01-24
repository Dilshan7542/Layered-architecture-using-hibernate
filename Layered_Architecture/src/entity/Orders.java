package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.sql.Date;
import java.util.List;

@Entity
public class Orders {
    @Id
    String oid;
    Date date;
    @ManyToOne
    Customer customer;

    @OneToMany(mappedBy = "order")
    List<OrderDetail> orderDetails;



    public Orders() {
    }

    public Orders(String oid, Date date, Customer customer) {
        this.oid = oid;
        this.date = date;
        this.customer = customer;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
