public class bat extends mammal{
    public bat(int energy){
        super(energy);
    }
    public void fly(){
        System.out.println("the bat flew! (-50)");
        energyLevel -= 50;
    }
    public void eatHumans(){
        System.out.println("The bat was hungry...for FLESH! (-25) ");
        energyLevel += 25;
    }
    public void attackTown(){
        System.out.println("The bat got angry, very angry... (-100)");
        energyLevel -= 100;
    }
}
