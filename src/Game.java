import java.util.Scanner;

public class Game {

    Scanner scan = new Scanner(System.in);
    Player player = new Player();


    public void start(){
    System.out.println("THE ACTION GAME");
    System.out.println("Please enter your name : ");
    player.userName();
    System.out.println("Welcome to the Action Game Dear " + player.getUserName());
    scan.nextLine();
    System.out.println("The last thing you remember is the boat trip you took with your best friend.");
    scan.nextLine();
    System.out.println("After that you passed out. Now you are on a small island in the middle of the sea. You have no idea how you got here");
    scan.nextLine();
    System.out.println("Could you was betrayed.");
    scan.nextLine();
    System.out.println("Anyway, forget it.");
    scan.nextLine();
    System.out.println("Suddenly you hear that the monster's voice.");
    scan.nextLine();
    System.out.println("You must only focus to survive. ");
    scan.nextLine();
    System.out.println("Please select character ; ");
    player.selectCharacter();
    player.selectLoc();


    }
}
