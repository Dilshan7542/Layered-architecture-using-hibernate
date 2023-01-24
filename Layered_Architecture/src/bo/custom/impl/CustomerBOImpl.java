package bo.custom.impl;

import bo.custom.CustomerBo;
import dao.DAOFactory;
import dao.custom.CustomerDAO;
import dto.CustomerDTO;
import entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl  implements CustomerBo {
    CustomerDAO crudDAO=(CustomerDAO)  DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    @Override
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
        final ArrayList<Customer> all = crudDAO.getAll();
        final ArrayList<CustomerDTO> customerDTO = new ArrayList<>();
        for (Customer c : all) {
            customerDTO.add(new CustomerDTO(
                    c.getId(),
                    c.getName(),
                    c.getAddress()
                    ));
        }
        return customerDTO;
    }

    @Override
    public boolean saveCustomer(CustomerDTO customerDTO) throws ClassNotFoundException, SQLException {
        return crudDAO.save(new Customer(
                customerDTO.getId(),
                customerDTO.getName(),
                customerDTO.getAddress()
        ));
    }

    @Override
    public boolean updateCustomer(CustomerDTO customerDTO) throws ClassNotFoundException, SQLException {
        return crudDAO.update(new Customer(
                customerDTO.getId(),
                customerDTO.getName(),
                customerDTO.getAddress()
        ));
    }

    @Override
    public boolean deleteCustomer(String id) throws ClassNotFoundException, SQLException {
        return crudDAO.delete(id);
    }

    @Override
    public String generateCustomerNewID() throws SQLException, ClassNotFoundException {
        return crudDAO.generateNewID();
    }
}
