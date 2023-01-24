package bo.custom;

import dto.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBo extends SuperBO{
   ArrayList<CustomerDTO> getAllCustomer()throws SQLException,ClassNotFoundException;
   boolean saveCustomer(CustomerDTO customerDTO)throws ClassNotFoundException,SQLException;
   boolean updateCustomer(CustomerDTO customerDTO)throws ClassNotFoundException,SQLException;
   boolean deleteCustomer(String id)throws ClassNotFoundException,SQLException;
    String generateCustomerNewID() throws SQLException, ClassNotFoundException ;
}
