import java.util.ArrayList;
import java.util.Arrays;
public class CafeUtil {
    public int GetStreakGoal(int numWeeks){
        int[] coffees = new int[numWeeks];
        int sum = 0;
        for (int i = 0; i < coffees.length;i++){
            coffees[i] = i+1;
            sum += coffees[i];
        }
        return sum;
    }
    public double getOrderTotal(double[] items){
        double sum = 0;
        for (int i = 0; i < items.length; i++){
            sum += items[i];
        }
        return sum;
    }
    public void displayMenu(ArrayList<String> menuItems){
        for (int i = 0; i < menuItems.size(); i++){
            System.out.println(i+ " " + menuItems.get(i));
        }
    }
    public void addCustomer (ArrayList<String> customers){
        System.out.println("Please enter your name: ");
        String username = System.console().readLine();
        System.out.println("Hello, " + username);
        System.out.println("There are "+customers.size()+" people in front of you.");
        customers.add(username);
        for (int i = 0; i<customers.size(); i++){
            System.out.println(customers.get(i));
        }
    }
    public void printPriceChart(String product, double price, int maxQuantity){
        System.out.println(product);
        for (int i = 1; i< maxQuantity; i++){
            System.out.println(i + " -  $" + String.format("%.2f", price*i));
        }
    }
    public void displayMenu(ArrayList<String> menuItems, ArrayList<Double> prices){
        for (int i = 0; i < menuItems.size(); i++){
            System.out.println(i+ " " + menuItems.get(i) + String.format(" -- $%.2f", prices.get(i)));
        }
    }
}
