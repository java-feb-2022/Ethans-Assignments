public class mammal{
    protected int energyLevel = 0;
    public mammal(int energy){
        energyLevel = energy;
    }
    public int getEnergyLevel(){
        System.out.println(energyLevel);
        return energyLevel;
    }
}
