import java.util.ArrayList;
public class testOrders {
    public static void main(String[] args) {
        OrderKiosk myOrder = new OrderKiosk();
        myOrder.addmenuItem("mocha", 2.55);
        myOrder.addmenuItem("latte", 3.25);
        myOrder.addmenuItem("drip coffee", 1.99);
        myOrder.addmenuItem("capuccino", 4.15);
        myOrder.newOrder();
    }
}
