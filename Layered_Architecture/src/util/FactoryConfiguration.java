package util;

import entity.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
   private SessionFactory sessionFactory;
    private FactoryConfiguration(){
        final Configuration configuration = new Configuration().configure().
                addAnnotatedClass(Customer.class).addAnnotatedClass(Item.class).
                addAnnotatedClass(Orders.class).addAnnotatedClass(OrderDetail.class);
        sessionFactory = configuration.buildSessionFactory();
    }
    public static FactoryConfiguration getInstance(){
       return factoryConfiguration==null ? factoryConfiguration=new FactoryConfiguration():factoryConfiguration;
    }
    public Session getSessionFactory(){
        return sessionFactory.openSession();
    }
}
