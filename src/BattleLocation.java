import java.util.Random;

public abstract class BattleLocation extends Location {
    private GameMonster gameMonster;
    private String award;
    private int maxMonster;

    public BattleLocation(Player player, String name, GameMonster gameMonster, String award, int maxMonster ){
    super(player,name);
    this.gameMonster=gameMonster;
    this.award=award;
    this.maxMonster=maxMonster;
    }
    @Override
    public boolean onLocation(){
        int randomnumber = randomMonsterNumber();
        System.out.println("Your current location : " + this.getPlaceName());
        System.out.println("Oh no, Be Careful. There are " + randomnumber +" monster " + this.getGameMonster().getCharacterName() + " live in here !");
        System.out.println("If you want to fight press <S> and ıf you want to escape press <E>");
        String selectCase=scan.nextLine();
        selectCase=selectCase.toUpperCase();
        if (selectCase.equals("S"))
        {
            combat(randomnumber);
        }
        else if (selectCase.equals("E")) {
            System.out.println("You ran away and saved your life.");
            getPlayer().selectLoc();
        }
        else{
            onLocation();
        }
        return true;
    }

    public boolean combat(int maxMonster){
        for (int i = 1 ; i <= maxMonster; i++){
            getGameMonster().setHealth(getGameMonster().getDefMonsterHealth());
            playerStats();
            monsterStats();
            while(getPlayer().getHealth()>0 && getGameMonster().getHealth()>0){
                System.out.println("Press <S> to hit. If you want to escape press <E>");
                if(scan.nextLine().toUpperCase().equals("S")){
                    getGameMonster().setHealth(getGameMonster().getHealth() - getPlayer().getDamage());
                    System.out.println("You hit monster !! Monster's health reduced to : " + getGameMonster().getHealth() + "\n Your health : " + getPlayer().getHealth());
                    getPlayer().setHealth(getPlayer().getHealth() - getGameMonster().getDamage());
                    if(getGameMonster().getHealth()!=0) {
                        System.out.println("The monster counterattacked !! Your health reduced to : " + getPlayer().getHealth() + "\n Monster's health : " + getGameMonster().getHealth());
                    }
                    if(getPlayer().getHealth()<=0){
                        System.out.println("---------------------------------------------------");
                        System.out.println("You Dead");
                        System.out.println("---------------------------------------------------");
                    }
                    if(getGameMonster().getHealth()<=0 && i<maxMonster){
                        System.out.println("---------------------------------------------------");
                        System.out.println("You killed  "+ i +". monster "+ getGameMonster().getCharacterName() +" \n ###### You earned : " + getGameMonster().getAward() + " ######");
                        System.out.println("---------------------------------------------------");
                        getPlayer().setMoney(getPlayer().getMoney() + getGameMonster().getAward());
                        System.out.println("You noticed new " + getGameMonster().getCharacterName()+" is coming" );
                        System.out.println("---------------------------------------------------");
                    }
                    if(i==maxMonster){
                        System.out.println("---------------------------------------------------");
                        System.out.println("You killed  "+ i +" monster "+ getGameMonster().getCharacterName() +" \n ###### You total earned : " + getGameMonster().getAward() * i + " ######");
                        System.out.println("---------------------------------------------------");
                        getPlayer().setMoney(getPlayer().getMoney() + getGameMonster().getAward());
                        getPlayer().selectLoc();
                    }
                }
            }
        }

        return true;
    }

    public void playerStats(){
        System.out.println("---------------------------------------------------");
        System.out.println("Player Info : ");
        System.out.println(getPlayer().getUserName().toUpperCase() + " : Health : " + getPlayer().getHealth() + " / Damage : "
                + getPlayer().getDamage()+ " / Money : "
                + getPlayer().getMoney()
                + " / The Weapon Used : " + getPlayer().getInverntory().getWeapon().getWeaponName()
                + " / The Armor Used : " + getPlayer().getInverntory().getArmor().getArmorName());
        System.out.println("---------------------------------------------------");

    }

    public void monsterStats(){
        System.out.println("Monster Info : ");
        System.out.println(getGameMonster().getCharacterName().toUpperCase() + " : Health : " + getGameMonster().getHealth() + " / Damage : "
                + getGameMonster().getDamage()
                + " /  Award : " + getGameMonster().getAward());
        System.out.println("---------------------------------------------------");
    }

    public int randomMonsterNumber(){
        Random randomNumber= new Random();
        return randomNumber.nextInt(getMaxMonster())+1;
    }

    public GameMonster getGameMonster() {
        return gameMonster;
    }

    public void setGameMonster(GameMonster gameMonster) {
        this.gameMonster = gameMonster;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }
    public int getMaxMonster(){
        return maxMonster;
    }
    public void setMaxMonster(int maxMonster){
        this.maxMonster=maxMonster;
    }

}
