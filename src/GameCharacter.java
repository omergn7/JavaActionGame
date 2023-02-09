public abstract class GameCharacter {

    /** the identification number of the character */
    private int id;
    /** the strength of the character's damage */
    private int damage;
    /** the number of the characters health */
    private int health;
    /** the money of that character have */
    private int money;
    /** the name of the character */
    private String characterName;


    /**
     * The Constructor
     *
     * @param id the identification number of the character
     * @param characterName the name of the character
     * @param damage the strength of the character's damage
     * @param health the number of the characters health
     * @param money the money of that character have
     * */

    public GameCharacter(int id, int damage, int health, int money, String characterName){
        this.id=id;
        this.damage=damage;
        this.health=health;
        this.money=money;
        this.characterName=characterName;
    }

    /** Change the character ID number
     * @param id
     * */
    public void setId(int id){
        this.id=id;
    }

    /** @return identification number of the character */
    public int getId(){
        return id;
    }

    /** Change the strengths that characters damage
     * @param damage
     * */
    public void setDamage(int damage){
        this.damage=damage;
    }

    /** @return the strength of the character's damage  */
    public int getDamage(){
        return damage;
    }

    /** @return the number of the characters health  */
    public int getHealth() {
        return health;
    }

    /** Change the characters healths
     * @param health
     *  */
    public void setHealth(int health) {
        this.health = health;
    }

    /** @return the money of that character have   */
    public int getMoney() {
        return money;
    }

    /**Change the money of that character have
     * @param money
     * */
    public void setMoney(int money) {
        this.money = money;
    }

    /** @return the name of the character */
    public String getCharacterName() {
        return characterName;
    }

    /** Change the name of the character
     * @param characterName
     * */
    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

}
