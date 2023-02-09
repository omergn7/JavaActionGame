import java.util.Scanner;

public class Player {

    Scanner scan=new Scanner(System.in);

    /** @param damage the strength of the character's damage */
    private int damage;

    /** @param health the number of the characters health */
    private int health;

    /** @param money the money of that character have */
    private int money;

    /** @param characterName the name of the character*/
    private String charName;

    /** @param userName the name given to the character by the user */
    private String userName;

    private Inverntory inverntory;

    private int defHealth;

    public Player(){
        this.inverntory=new Inverntory();
    }

    public String userName(){
        String userName_ = scan.nextLine();
        this.userName=userName_;
        return userName_;
    }

    public String getUserName() {
        return userName;
    }

    public int getDamage(){
        return damage + getInverntory().getWeapon().getDamage();
    }

    public void setDamage(int damage){
        this.damage=damage;
    }

    public int getHealth(){
        return health;
    }

    public void setHealth(int health){
        this.health=health;
    }

    public int getMoney(){
        return money;
    }

    public void setMoney(int money){
        this.money=money;
    }

    public String getCharName(){
        return charName;
    }

    public void setCharName(String charName){
        this.charName=charName;
    }

    public void inItPlayer(GameCharacter gameCharacter){
        setMoney(gameCharacter.getMoney());
        setHealth(gameCharacter.getHealth());
        setDefHealth(gameCharacter.getHealth());
        setCharName(gameCharacter.getCharacterName());
        setDamage(gameCharacter.getDamage());
    }

    public void selectCharacter(){

        GameCharacter[] characterList={new Knight(), new Archer(), new Samurai()};
        System.out.println("--------------------------------------------------------------");
        for (GameCharacter gameCharacter:characterList) {
            System.out.println("Character Info : Character ID : " + gameCharacter.getId() + " || Character Name : " + gameCharacter.getCharacterName() + " || Character Damage : " + gameCharacter.getDamage() + "|| Character Health : " + gameCharacter.getHealth() + " || Character Money : " + gameCharacter.getMoney() );

        }

        switch (scan.nextInt()){
            case 1 : System.out.println("Knight is selected");
            inItPlayer(new Knight());
                break;
            case 2 : System.out.println("Archer is selected");
            inItPlayer(new Archer());
                break;
            case 3 : System.out.println("Samurai is selected");
            inItPlayer(new Samurai());
                break;
            default:System.out.println("Knight is selected (Knight is selected automatically because wrong parameter is entered.\n)");
                inItPlayer(new Knight());
        }
    }

    public void selectLoc(){
        Location location_=null;
        System.out.println("---------------------------------------------------");
        System.out.println("Religions");
        String[] location = {"" +
                "0-View Player Stats (Get a number of character's health, damage, money",
                "1-Safe House (There is no monster and your health is renewed here.)",
                "2-Tool Store (You can take weapon or armor in there.)",
                "3-Forest (It mıght be a lot of vampire over there. Award : Wood)",
                "4-Cave (It mıght be a lot of zombie over there. Award : Food)",
                "5-River (It mıght be a lot of bear over there. Award : Water)",
                "6-Leave Game"};
        System.out.println("---------------------------------------------------");
        for(int i=0;i < location.length ;i++ ) {
        System.out.println(location[i]);
        }
        System.out.println("Please select Location.");
        int selectLocation = scan.nextInt();
        switch (selectLocation){

            case 0 : System.out.println(getUserName().toUpperCase() + " : Health : " + getHealth() + " / Damage : "
                    + getDamage()+ " / Money : "
                    + getMoney()
                    + " / The Weapon Used : " + getInverntory().getWeapon().getWeaponName()
                    + " / The Armor Used : " + getInverntory().getArmor().getArmorName());
                location_= new SafeHouse(this);
                break;

            case 1:  System.out.println("Safe house is selected.");
                location_= new SafeHouse(this);
                break;
            case 2:  System.out.println("Tool Store is selected.");
                location_= new ToolStore(this);
                break;
            case 3:  System.out.println("Forest is selected.");
                location_= new Forest(this);
                break;
            case 4:  System.out.println("Cave is selected.");
                location_= new Cave(this);
                break;
            case 5:  System.out.println("River is selected.");
                location_= new River(this);
                break;
            case 6: System.out.println("Leave Game");
                   return;


            default: System.out.println("Safe house is selected.");
                location_= new SafeHouse(this);

        }

        location_.onLocation();

        if(getHealth()>0) {
            selectLoc();
        }
        else {
            System.out.println("You are dead.");
            System.out.println("TRY AGAIN");
        }
    }
    public void setInverntory(Inverntory inverntory){
        this.inverntory=inverntory;
    }
    public Inverntory getInverntory(){
        return inverntory;
    }

    public int getDefHealth() {
        return defHealth;
    }

    public void setDefHealth(int defHealth) {
        this.defHealth = defHealth;
    }
}
