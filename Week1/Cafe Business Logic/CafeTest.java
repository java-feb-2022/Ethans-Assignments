import java.util.ArrayList;
import java.util.Arrays;
public class CafeTest {
    public static void main(String[] args) {
        
        CafeUtil appTest = new CafeUtil();
        System.out.println("\n----- Streak Goal Test -----");
        System.out.printf("Purchases needed by week 10: %s \n\n", appTest.GetStreakGoal(10));
    
        System.out.println("----- Order Total Test-----");
        double[] lineItems = {3.5, 1.5, 4.0, 4.5};
        System.out.printf("Order total: %s \n\n",appTest.getOrderTotal(lineItems));
        System.out.println("----- Display Menu Test-----");
        
        ArrayList<String> menu = new ArrayList<String>();
        menu.add("drip coffee");
        menu.add("cappuccino");
        menu.add("latte");
        menu.add("mocha");
        appTest.displayMenu(menu);
    
        System.out.println("\n----- Add Customer Test-----");
        ArrayList<String> customers = new ArrayList<String>();
        for (int i = 0; i < 4; i++) {
            appTest.addCustomer(customers);
            System.out.println("\n");
        }

        appTest.printPriceChart("Coca-Cola", 5.50, 10);

        ArrayList<Double> prices = new ArrayList<Double>();
        prices.add(2.65);
        prices.add(4.50);
        prices.add(3.20);
        prices.add(5.00);
        appTest.displayMenu(menu, prices);
    }
}
