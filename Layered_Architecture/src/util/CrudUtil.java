package util;

import db.DBConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CrudUtil {
    public static  <T> T execute(String sql,Object... args) throws SQLException, ClassNotFoundException {
        final PreparedStatement st = DBConnection.getDbConnection().getConnection().prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            st.setObject(i+1,args[i]);

        }
        if(sql.startsWith("SELECT") || sql.startsWith("Select")){
            return (T)st.executeQuery();
        }
            return (T)(Boolean)(st.executeUpdate()>0);
    }
}
