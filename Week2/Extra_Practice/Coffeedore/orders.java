import java.util.ArrayList;
public class orders {
    private String name;
    private double total;
    private boolean ready;
    private ArrayList<items> items = new ArrayList<items>();
    public orders(){
        this.name = "Guest";
        this.ready = false;
    }
    public orders(String name){
        this.name = name;
        this.ready = false;
    }
    public void addItem(items item){
        this.items.add(item);
    }
    public void setStatus(boolean status){
        this.ready = status;
    }
    public String getStatusMessage(){
        if (this.ready){
            return "Your order is ready.";
        }
        return "Your order is not ready yet.";
    }
    public String getOrderTotal(){
        double total = 0;
        for (items i: this.items){
            total += i.getPrice();
        }
        return "your total is: "+total;
    }
    public void display(){
        System.out.println("order name: "+this.name);
        for (items i : this.items) {
            System.out.println(i.getName()+ " - $"+ i.getPrice());
        }
        if(this.ready){
            System.out.println("Order is ready.");
        }
        else{
            System.out.println("Order is not ready.");
        }
        System.out.println("Total is: "+this.getOrderTotal());
        
    }
}
