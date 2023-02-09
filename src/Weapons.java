public abstract class Weapons {

    private String weaponName;
    private int id;
    private int damage;
    private int salary;

    public Weapons(int id, int damage, int salary, String weaponName) {
        this.id = id;
        this.damage = damage;
        this.salary = salary;
        this.weaponName=weaponName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }
}
