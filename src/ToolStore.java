public class ToolStore extends NormalLoc {
    public ToolStore(Player player){
        super(player, "Tool Store");
    }
    public void currentBalance(){
        System.out.println("---------------------------------------------------");
        System.out.println("Current Balance : " + getPlayer().getMoney());
        System.out.println("---------------------------------------------------");
    }

    public void infussicientBalance(){
        System.out.println("---------------------------------------------------");
        System.out.println("Insufficient balance"); currentBalance();  onLocation();
        System.out.println("---------------------------------------------------");
    }

    public void weaponSelect(int selectedWeapon) {
        Weapons[] weapons = {new Pistol(), new Sword(), new Rifle()};
        if(getPlayer().getMoney() >= weapons[selectedWeapon - 1].getSalary()) {
            System.out.println("You taken a " + weapons[selectedWeapon - 1].getWeaponName());
            int oldDamage = getPlayer().getDamage();
            getPlayer().setDamage(getPlayer().getDamage() + weapons[selectedWeapon - 1].getDamage());
            System.out.println("Your damage power upgraded from " + oldDamage + " to " + getPlayer().getDamage());
            System.out.println("Previous Weapon : " + getPlayer().getInverntory().getWeapon().getWeaponName());
            getPlayer().getInverntory().setWeapon(weapons[selectedWeapon - 1]);
            System.out.println("New Weapon : " + weapons[selectedWeapon - 1].getWeaponName());
            getPlayer().setMoney(getPlayer().getMoney() - weapons[selectedWeapon - 1].getSalary());
            currentBalance();
        }
        else {
            infussicientBalance();
        }
    }
    public void armorSelect(int selectedArmor){
        Armor[] armors={new LittleArmor(),new MiddleArmor(), new LargeArmor()};
        if( getPlayer().getMoney() >= armors[selectedArmor-1].getSalary()){
            System.out.println("You taken a " + armors[selectedArmor - 1].getArmorName() );
            int oldDefence = getPlayer().getHealth();
            getPlayer().setHealth(getPlayer().getHealth() + armors[selectedArmor -1].getDefence());
            System.out.println("Your health power upgraded from " + oldDefence + " to "+ getPlayer().getHealth());
            System.out.println("Previous Armor : " + getPlayer().getInverntory().getArmor().getArmorName());
            getPlayer().getInverntory().setArmor(armors[selectedArmor-1]);
            System.out.println("New Armor : " + armors[selectedArmor-1].getArmorName());
            getPlayer().setMoney(getPlayer().getMoney()-armors[selectedArmor-1].getSalary());
            currentBalance();
        }
        else {
            infussicientBalance();
        }
    }
    @Override
    public boolean onLocation(){

        System.out.println("You are in the Tool Store right now.");
        System.out.println("If you have enough money, you can take armor or weapon.");
        System.out.println("If you want to buy weapon press 1, if you wanto to buy a armor press 2, and if you want to exit press 3.");
        System.out.println("1- WEAPONS \n2- ARMOR \n3- EXIT");

        int usnum= scan.nextInt();
        switch (usnum){
            case 1:System.out.println("Current Balance :\n" + getPlayer().getMoney());
                   System.out.println("----------------------WEAPONS----------------------" );
                   Weapons[] weapons={new Pistol(), new Sword(), new Rifle()};
                for (Weapons weapons1:weapons) {
                   System.out.println("Weapon Name : "+ weapons1.getWeaponName() +"Weapon ID : " + weapons1.getId() + " Weapon Damage : " + weapons1.getDamage() + " Weapon Salary : " + weapons1.getSalary());
                }
                int selectedWeapon = scan.nextInt();
                        weaponSelect(selectedWeapon);
                break;
            case 2:System.out.println("----------------------ARMOR----------------------");
                Armor[] armors={new LittleArmor(), new MiddleArmor(), new LargeArmor()};
                for (Armor armors1:armors) {
                    System.out.println("Armor Name : "+ armors1.getArmorName() +"Armor ID : " + armors1.getId() + " Armor Defence: " + armors1.getDefence() + " Armor Salary : " + armors1.getSalary());
                }
                int selectedArmor = scan.nextInt();
                armorSelect(selectedArmor);
                break;
            case 3:System.out.println("You left from Tool Store "); getPlayer().selectLoc();
                break;
            default: System.out.println("You logged in wrong. Try Again"); onLocation();
        }
        return true;
    }
}