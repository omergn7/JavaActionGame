import java.util.Scanner;

// Can yenileme kımı düzeltilecek.

public class SafeHouse extends NormalLoc {

    Scanner scan=new Scanner(System.in);
    public SafeHouse(Player player){
        super(player, "Safe House");
    }

    @Override
    public boolean onLocation(){
        System.out.println("You are in the Safe House.");
        scan.nextLine();
        System.out.println("Your health is full.");
        getPlayer().setHealth(getPlayer().getDefHealth());
        return true;
    }

}
