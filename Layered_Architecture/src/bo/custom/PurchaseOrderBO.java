package bo.custom;

import dto.CustomerDTO;
import dto.ItemDTO;
import dto.OrderDTO;
import dto.OrderDetailDTO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface PurchaseOrderBO extends SuperBO{
    boolean saveOrder(OrderDTO orderDTO)throws SQLException,ClassNotFoundException;
    CustomerDTO searchCustomer(String id)throws ClassNotFoundException,SQLException;
    ArrayList<CustomerDTO> getAllCustomer()throws ClassNotFoundException,SQLException;
    ArrayList<ItemDTO> getAllItem()throws ClassNotFoundException,SQLException;
    ItemDTO searchItem(String code)throws ClassNotFoundException,SQLException;
    boolean existCustomer(String id)throws ClassNotFoundException,SQLException;
    boolean existItem(String code)throws ClassNotFoundException,SQLException;
    String generateOrderID()throws ClassNotFoundException,SQLException;
}
