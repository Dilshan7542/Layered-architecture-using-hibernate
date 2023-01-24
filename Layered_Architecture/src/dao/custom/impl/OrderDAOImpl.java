package dao.custom.impl;

import dao.custom.OrderDAO;
import db.DBConnection;

import entity.Orders;
import util.CrudUtil;

import java.sql.*;
import java.util.ArrayList;

public class OrderDAOImpl implements OrderDAO {
        public String generateNewOrderId() throws SQLException, ClassNotFoundException {

                Connection connection = DBConnection.getDbConnection().getConnection();
                Statement stm = connection.createStatement();
                ResultSet rst = stm.executeQuery("SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1;");
                return rst.next() ? String.format("OID-%03d", (Integer.parseInt(rst.getString("oid").replace("OID-", "")) + 1)) : "OID-001";


        }
        public PreparedStatement searchOrder(String id) throws SQLException, ClassNotFoundException {
                Connection connection = DBConnection.getDbConnection().getConnection();
            PreparedStatement stm = connection.prepareStatement("SELECT oid FROM `Orders` WHERE oid=?");
            stm.setString(1, id);
            /*if order id already exist*/
        if(stm.executeQuery().next()){
            return stm;
        }


        return null;

        }

    @Override
    public ArrayList<Orders> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    public boolean save(Orders order) throws SQLException, ClassNotFoundException {
      return   CrudUtil.execute("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)",
                order.getOid(),
               order.getDate(),
                order.getCustomer().getId());

    }

    @Override
    public boolean update(Orders entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean exist(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public Orders search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }
}
