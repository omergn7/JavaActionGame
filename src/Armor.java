public abstract class Armor {

    private String armorName;
    private int id;
    private int defence;
    private int salary;

    public Armor(int id, int defence, int salary, String armorName) {
        this.id = id;
        this.defence = defence;
        this.salary = salary;
        this.armorName=armorName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getArmorName() {
        return armorName;
    }

    public void setArmorName(String armorName) {
        this.armorName = armorName;
    }
}
