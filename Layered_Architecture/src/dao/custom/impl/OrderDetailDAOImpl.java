package dao.custom.impl;

import dao.custom.OrderDetailDAO;

import entity.OrderDetail;
import util.CrudUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailDAOImpl implements OrderDetailDAO {
    @Override
    public ArrayList<OrderDetail> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    public boolean save(OrderDetail orderDetailDTO) throws SQLException, ClassNotFoundException {

        return CrudUtil.execute("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)",
                orderDetailDTO.getOrder().getOid(),
                orderDetailDTO.getItem(),
                orderDetailDTO.getUnitPrice(),
                orderDetailDTO.getQty());

    }

    @Override
    public boolean update(OrderDetail dao) throws SQLException, ClassNotFoundException {
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
    public OrderDetail search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    public boolean saveAll(List<OrderDetail> list) throws SQLException, ClassNotFoundException {
        for (OrderDetail or : list) {
            if (!save(or)) {
                return false;
            }
        }
        return true;
    }
}
