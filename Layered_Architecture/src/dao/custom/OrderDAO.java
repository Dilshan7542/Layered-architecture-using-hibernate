package dao.custom;


import dao.CrudDAO;
import entity.Orders;


import java.sql.*;

public interface OrderDAO  extends CrudDAO<Orders,String> {
    String generateNewOrderId() throws SQLException, ClassNotFoundException;
    PreparedStatement searchOrder(String id) throws SQLException, ClassNotFoundException;
    boolean save(Orders order) throws SQLException, ClassNotFoundException ;
}
