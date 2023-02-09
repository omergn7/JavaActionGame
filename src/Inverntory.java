

public class Inverntory {
    private Weapons weapon;
    private Armor armor;

    public Inverntory(){
        this.weapon=new Punch();
        this.armor=new Wood();
    }

    public Weapons getWeapon(){
        return weapon;
    }

    public void setWeapon(Weapons weapon){
        this.weapon=weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }
}
