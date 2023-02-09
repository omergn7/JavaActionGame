import java.util.Scanner;
public abstract class Location {

    Scanner scan=new Scanner(System.in);

    private Player player;

    private String placeName;

    public Location(Player player, String placeName){
        this.player=player;
        this.placeName=placeName;
    }

    public abstract boolean onLocation();


    public Player getPlayer(){
        return player;
    }

    public void setPlayer(Player player){
        this.player=player;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

}
