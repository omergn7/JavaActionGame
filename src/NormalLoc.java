public class NormalLoc extends Location{

    public NormalLoc(Player player, String placeName){
        super(player,placeName);
    }

    @Override
    public boolean onLocation(){
        return true;
    }

}
