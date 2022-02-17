import java.util.ArrayList;
public class testOrders {
    public static void main(String[] args) {
        items item1 = new items("mocha", 2.55);
        items item2 = new items("latte", 3.25);
        items item3 = new items("drip coffee", 1.99);
        items item4 = new items("capuccino", 4.15);


        orders order1 = new orders("Noah");
        orders order2 = new orders("Cindhuri");
        orders order3 = new orders();
        orders order4 = new orders();


        order1.addItem(item1);
        order3.addItem(item4);
        order4.addItem(item2);
        order1.setStatus(true);
        order4.addItem(item2);
        order4.addItem(item2);
        order4.setStatus(true);
        order1.display();
        order2.display();
        order3.display();
        order4.display();

    }
}
