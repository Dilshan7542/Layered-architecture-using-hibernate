package bo.custom;

import dto.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBO extends SuperBO{
    boolean saveItem(ItemDTO itemDTO)throws ClassNotFoundException, SQLException;
    boolean updateItem(ItemDTO itemDTO)throws ClassNotFoundException, SQLException;
    boolean deleteItem(String id)throws ClassNotFoundException, SQLException;
    ArrayList<ItemDTO> getAllItem()throws ClassNotFoundException,SQLException;
    ItemDTO searchItem(String id)throws ClassNotFoundException,SQLException;
    boolean existItem(String id)throws ClassNotFoundException,SQLException;
    String  generateNewID()throws ClassNotFoundException,SQLException;

}
