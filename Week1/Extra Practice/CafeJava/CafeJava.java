public class CafeJava{
    public static void main(String[] args){
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
        double mochaPrice = 3.5;
        double dripCoffee = 2.0;
        double latte = 5.2;
        double cappucino = 6.9;
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";
        boolean isReadyOrder1 = true;
        boolean isReadyOrder2 = true;
        boolean isReadyOrder3 = true;
        boolean isReadyOrder4 = true;
        System.out.println(generalGreeting + customer1); 
        if(isReadyOrder1){
            System.out.println(customer1 + readyMessage);
        }
        else{
            System.out.println(customer1 + pendingMessage);
        }
        if(isReadyOrder2){
            System.out.println(customer2 + readyMessage);
            System.out.println(displayTotalMessage + String.valueOf(cappucino));
        }
        else{
            System.out.println(customer2 + pendingMessage);
        }
        if(isReadyOrder3){
            System.out.println(customer3 + readyMessage);
            System.out.println(displayTotalMessage + String.valueOf(latte*2));
        }
        else{
            System.out.println(customer3 + pendingMessage);
        }
        if(isReadyOrder4){
            System.out.println(customer4 + readyMessage);
            System.out.println(displayTotalMessage + String.valueOf(latte - dripCoffee));
        }
        else{
            System.out.println("Your coffee isn't ready yet, " + customer4);
        }
    }
}