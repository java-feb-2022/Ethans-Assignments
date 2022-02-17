public class gorilla extends mammal {
    public gorilla(int energy){
        super(energy);
    }
    public void throwSomething (){
        System.out.println("the gorilla throws something.");
        this.energyLevel -= 5;
    }
    public void eatBananas(){
        System.out.println("gorilla eats bananas.");
        energyLevel +=10;
    }
    public void climb(){
        System.out.println("gorilla climbs");
        energyLevel -= 10;
    }
}
