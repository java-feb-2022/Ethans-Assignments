public class items{
    private String name;
    private double price;
    public items(){}

    public items(String name, double price) {
    this.name = name;
    this.price = price;
    }
    public String getName(){
        return this.name;
    }
      
    public double getPrice(){
        return this.price;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
}