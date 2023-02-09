public abstract class GameMonster {

    /** the identification number of the monster */
    private int id;
    /** the strength of the monster's damage */
    private int damage;
    /** the number of the monster's health */
    private int health;

    /** the name of the monster */
    private String monsterName;

    private int award;

    private int defMonsterHealth;

    /**
     * The Constructor
     *
     * @param id the identification number of the monster
     * @param monsterName the name of the monster
     * @param damage the strength of the monster's damage
     * @param health the number of the monster's health
     * */

    public GameMonster(int id, int damage, int health, String monsterName, int award, int defMonsterHealth){
        this.id=id;
        this.damage=damage;
        this.health=health;
        this.monsterName=monsterName;
        this.award=award;
        this.defMonsterHealth=defMonsterHealth;
    }
    /** Change the monster ID number
     * @param id
     * */
    public void setId(int id){
        this.id=id;
    }

    /** @return identification number of the monster */
    public int getId(){
        return id;
    }

    /** Change the strengths that monster's damage
     * @param damage
     * */
    public void setDamage(int damage){
        this.damage=damage;
    }

    /** @return the strength of the monster's damage  */
    public int getDamage(){
        return damage;
    }

    /** @return the number of the monster's health  */
    public int getHealth() {
        return health;
    }

    /** Change the monste's healths
     * @param health
     *  */
    public void setHealth(int health) {
        if(health<0){
            health=0;
        }
        this.health = health;

    }

    /** @return the name of the monster */
    public String getCharacterName() {
        return monsterName;
    }

    /** Change the name of the monster
     * @param monsterName
     * */
    public void setCharacterName(String monsterName) {
        this.monsterName = monsterName;
    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }

    public int getDefMonsterHealth() {
        return defMonsterHealth;
    }

    public void setDefMonsterHealth(int defMonsterHealth) {
        this.defMonsterHealth = defMonsterHealth;
    }
}


