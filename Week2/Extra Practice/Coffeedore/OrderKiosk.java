import java.util.ArrayList;
public class OrderKiosk {
    ArrayList<items> menu;
    ArrayList<orders> orders;
    public OrderKiosk(){
        this.menu = new ArrayList<>();
        this.orders = new ArrayList<>();
    }
    public void addmenuItem(String name, double price){
        items Item = new items(name, price);
        this.menu.add(Item);
    }
    public void displayMenu (){
        int index = 0;
        for (items i: this.menu){
            System.out.println(index + " " + i.getName() + " $" + i.getPrice() );
            index++;
        }
    }
    public void newOrder(){
        System.out.println("Please enter customer name for new order:");
        String name = System.console().readLine();
        orders order = new orders(name);
        displayMenu();
        System.out.println("Please enter a menu item index or q to quit:");
        String input = System.console().readLine();
        while (!input.equals("q")){
            order.addItem(menu.get(Integer.parseInt(input)));
            input = System.console().readLine();
        }
        order.display();
    }
}

