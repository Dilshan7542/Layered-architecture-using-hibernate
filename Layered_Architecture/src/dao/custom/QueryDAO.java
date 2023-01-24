package dao.custom;

import dao.SuperDAO;
import entity.Custom;


import java.sql.SQLException;
import java.util.ArrayList;

public interface QueryDAO extends SuperDAO {
        ArrayList<Custom> searchOrderByOrderID(String id)throws ClassNotFoundException, SQLException;
}
