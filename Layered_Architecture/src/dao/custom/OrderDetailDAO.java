package dao.custom;

import dao.CrudDAO;
import entity.OrderDetail;


import java.sql.SQLException;
import java.util.List;

public interface OrderDetailDAO extends CrudDAO<OrderDetail,String> {
    boolean save(OrderDetail orderDetailDTO) throws SQLException, ClassNotFoundException;
    boolean saveAll(List<OrderDetail> list) throws SQLException, ClassNotFoundException;
}
