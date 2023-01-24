package bo.custom.impl;

import bo.custom.ItemBO;
import dao.custom.ItemDAO;
import dao.DAOFactory;

import dto.ItemDTO;
import entity.Item;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl implements ItemBO {
        ItemDAO itemDAO=(ItemDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ITEM);
    @Override
    public boolean saveItem(ItemDTO itemDTO) throws ClassNotFoundException, SQLException {
        return itemDAO.save(new Item(
                itemDTO.getCode(),
                itemDTO.getDescription(),
                itemDTO.getUnitPrice(),
                itemDTO.getQtyOnHand()
        ));
    }
    @Override
    public boolean updateItem(ItemDTO itemDTO) throws ClassNotFoundException, SQLException {
       return itemDAO.update(new Item(
               itemDTO.getCode(),
               itemDTO.getDescription(),
               itemDTO.getUnitPrice(),
               itemDTO.getQtyOnHand()
       ));
    }

    @Override
    public boolean deleteItem(String id) throws ClassNotFoundException, SQLException {
        return itemDAO.delete(id);
    }

    @Override
    public ArrayList<ItemDTO> getAllItem() throws ClassNotFoundException, SQLException {
         ArrayList<Item> allItem = itemDAO.getAll();
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
    public ItemDTO searchItem(String id) throws ClassNotFoundException, SQLException {
        final Item search = itemDAO.search(id);
        return new ItemDTO(
                search.getCode(),
                search.getDescription(),
                search.getUnitPrice(),
                search.getQtyOnHand()
        );

    }
    @Override
    public boolean existItem(String id) throws ClassNotFoundException, SQLException {
        return itemDAO.exist(id);
    }

    @Override
    public String generateNewID() throws ClassNotFoundException, SQLException {
        return itemDAO.generateNewID();
    }
}
