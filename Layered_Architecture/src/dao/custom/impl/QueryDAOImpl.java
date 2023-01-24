package dao.custom.impl;

import dao.custom.QueryDAO;
import dto.CustomerDTO;
import entity.Custom;

import java.sql.SQLException;
import java.util.ArrayList;

public class QueryDAOImpl implements QueryDAO {
    @Override
    public ArrayList<Custom> searchOrderByOrderID(String id) throws ClassNotFoundException, SQLException {
        return null;
    }
}
