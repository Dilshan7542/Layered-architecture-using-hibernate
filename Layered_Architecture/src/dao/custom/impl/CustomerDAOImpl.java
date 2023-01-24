package dao.custom.impl;

import dao.custom.CustomerDAO;
import db.DBConnection;
import entity.Customer;
import org.hibernate.Session;
import util.CrudUtil;
import util.FactoryConfiguration;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {




    public void completeSession(Session session) {
        session.beginTransaction().commit();

    }

    public ArrayList<Customer> getAll() throws SQLException, ClassNotFoundException {
        final Session s1 = FactoryConfiguration.getInstance().getSessionFactory();
        final Customer customer = s1.get(Customer.class, "C00-001");
        final Customer customer2 = s1.get(Customer.class, "C00-001");
        final ArrayList<Customer> customerArrayList = new ArrayList<>(s1.createQuery("FROM Customer").list());
        s1.createQuery("FROM Customer").list();
        System.out.println(customer2.getName());
        System.out.println(customer.getName());
        s1.beginTransaction().commit();
            s1.close();

        return customerArrayList;
    }

    public boolean save(Customer customerEntity) throws SQLException, ClassNotFoundException {
        final Session session = FactoryConfiguration.getInstance().getSessionFactory();
        session.save(customerEntity);
        completeSession(session);
        return false;
    }

    public boolean update(Customer customer) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE Customer SET name=?, address=? WHERE id=?", customer.getName(),
                customer.getAddress(),
                customer.getId());

    }

    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT id FROM Customer WHERE id=?", id);
        return rst.next();
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("DELETE FROM Customer WHERE id=?", id);


    }

    public String generateNewID() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        ResultSet rst = connection.createStatement().executeQuery("SELECT id FROM Customer ORDER BY id DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("id");
            int newCustomerId = Integer.parseInt(id.replace("C00-", "")) + 1;
            return String.format("C00-%03d", newCustomerId);
        } else {
            return "C00-001";
        }

    }

    public Customer search(String id) throws SQLException, ClassNotFoundException {
        final Session session = FactoryConfiguration.getInstance().getSessionFactory();
        final Customer customer = session.get(Customer.class, id);
        final Customer custome2 = session.get(Customer.class, id);
        System.out.println("s2 :"+session);
        return customer;
    }


}
