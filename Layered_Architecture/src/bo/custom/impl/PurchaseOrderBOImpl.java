package bo.custom.impl;

import bo.custom.PurchaseOrderBO;
import dao.custom.CustomerDAO;
import dao.custom.ItemDAO;
import dao.custom.OrderDAO;
import dao.custom.OrderDetailDAO;
import dao.DAOFactory;
import db.DBConnection;
import dto.CustomerDTO;
import dto.ItemDTO;
import dto.OrderDTO;
import dto.OrderDetailDTO;
import entity.Customer;
import entity.Item;
import entity.OrderDetail;
import entity.Orders;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;


public class PurchaseOrderBOImpl implements PurchaseOrderBO {
    OrderDAO orderDAO=(OrderDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDER);
    OrderDetailDAO orderDetailDAO=(OrderDetailDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDER_DETAIL);
    ItemDAO itemDAO=(ItemDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ITEM) ;
    CustomerDAO customerDAO=(CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    @Override
    public boolean saveOrder(OrderDTO orderDTO) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();;
            connection.setAutoCommit(false);

            if (!orderDAO.save(new Orders(orderDTO.getOrderId(), Date.valueOf(orderDTO.getOrderDate()),customerDAO.search(orderDTO.getCustomerId())))) {
                connection.rollback();
                return false;
            }else {

                for (OrderDetailDTO dt : orderDTO.getOrderDetailDTOList()) {

                   if(!orderDetailDAO.save(new OrderDetail(orderDAO.search(orderDTO.getOrderId()),itemDAO.search(dt.getItemCode()),dt.getUnitPrice(),dt.getQty()))){
                       connection.rollback();
                       return false;
                   }
               //Search & Update Item
                    Item item = itemDAO.search(dt.getItemCode());
                    item.setQtyOnHand(item.getQtyOnHand() - dt.getQty());
                    if (!itemDAO.update(item)) {
                        connection.rollback();
                        return false;
                    }
                }
                connection.commit();
                return true;
            }
    }
    @Override
    public CustomerDTO searchCustomer(String id) throws ClassNotFoundException, SQLException {
        final Customer search = customerDAO.search(id);
        return new CustomerDTO(search.getId(),search.getName(),search.getAddress());
    }
    @Override
    public ArrayList<CustomerDTO> getAllCustomer() throws ClassNotFoundException, SQLException {
        final ArrayList<Customer> all = customerDAO.getAll();
        ArrayList<CustomerDTO> customerDTOS=new ArrayList<>();
        for (Customer c : all) {
            customerDTOS.add(new CustomerDTO(c.getId(),c.getName(),c.getAddress()));
        }
        return customerDTOS;
    }
    @Override
    public ArrayList<ItemDTO> getAllItem() throws ClassNotFoundException, SQLException {
        final ArrayList<Item> allItem = itemDAO.getAll();
        ArrayList<ItemDTO> itemDTOArrayList=new ArrayList<>();
        for (Item item : allItem) {
            itemDTOArrayList.add(new ItemDTO(
                    item.getCode(),
                    item.getDescription(),
                    item.getUnitPrice(),
                    item.getQtyOnHand()
            ));
        }
        return itemDTOArrayList;
    }
    @Override
    public ItemDTO searchItem(String code) throws ClassNotFoundException, SQLException {
        final Item search = itemDAO.search(code);
        return new ItemDTO(
                search.getCode(),
                search.getDescription(),
                search.getUnitPrice(),
                search.getQtyOnHand()
        );
    }
    @Override
    public boolean existCustomer(String id) throws ClassNotFoundException, SQLException {
        return customerDAO.exist(id);
    }
    @Override
    public boolean existItem(String code) throws ClassNotFoundException, SQLException {
        return itemDAO.exist(code);
    }
    @Override
    public String generateOrderID() throws ClassNotFoundException, SQLException {
        return orderDAO.generateNewOrderId();
    }
}
