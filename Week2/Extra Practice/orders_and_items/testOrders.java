import java.util.ArrayList;
public class testOrders {
    public static void main(String[] args) {
        items item1 = new items();
        items item2 = new items();
        items item3 = new items();
        items item4 = new items();

        item1.name = "mocha";
        item1.price = 2.55;
        item2.name = "latte";
        item2.price = 3.25;
        item3.name = "drip coffee";
        item3.price = 1.99;
        item4.name = "capuccino";
        item4.price = 4.15;
        
        orders order1 = new orders();
        orders order2 = new orders();
        orders order3 = new orders();
        orders order4 = new orders();

        order1.name = "Cindhuri";
        order2.name = "Jimmy";
        order3.name = "Noah";
        order4.name = "Sam";
        order1.items.add(item1);
        order1.total += item1.price;
        order3.items.add(item4);
        order3.total += item4.price;
        order4.items.add(item2);
        order4.total += item2.price;
        order1.ready = true;
        order4.items.add(item2);
        order4.total += item2.price;
        order4.items.add(item2);
        order4.total += item2.price;
        order4.ready = true;
        System.out.println("Name: "+ order1.name);
        System.out.println("Total: "+ order1.total);
        System.out.println("Ready: "+ order1.ready);

        System.out.println("Name: "+ order2.name);
        System.out.println("Total: "+ order2.total);
        System.out.println("Ready: "+ order2.ready);

        System.out.println("Name: "+ order3.name);
        System.out.println("Total: "+ order3.total);
        System.out.println("Ready: "+ order3.ready);
    
        System.out.println("Name: "+ order4.name);
        System.out.println("Total: "+ order4.total);
        System.out.println("Ready: "+ order4.ready);

    }
}
