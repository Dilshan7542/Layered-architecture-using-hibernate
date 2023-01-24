package bo.custom;

import bo.custom.impl.CustomerBOImpl;
import bo.custom.impl.ItemBOImpl;
import bo.custom.impl.PurchaseOrderBOImpl;

public class BOFactory {
            private static BOFactory boFactory;
            private BOFactory(){}
    public static BOFactory getInstance(){
                return boFactory == null ? boFactory=new BOFactory():boFactory;
    }
    public SuperBO getBO(BOType boType){
        switch (boType) {
            case CUSTOMER:
                return new CustomerBOImpl();
            case ITEM:
                return new ItemBOImpl();
            case PURCHASE:
                return new PurchaseOrderBOImpl();
            default:return null;
        }
    }
    public enum BOType{
        CUSTOMER,ITEM,PURCHASE,QUERY
    }
}
