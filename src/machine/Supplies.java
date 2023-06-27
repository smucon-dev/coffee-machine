package machine;

public class Supplies {

    private int water = 0;
    private int milk = 0;
    private int beans = 0;
    private int cups = 0;

    public Supplies(int water, int milk, int beans, int cups) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cups = cups;
    }

    boolean brew(Coffee coffee) {
        if (this.water < coffee.getWater()) {
            System.out.println("Sorry, not enough water!");
            return false;
        } else if (this.milk < coffee.getMilk()) {
            System.out.println("Sorry, not enough milk!");
            return false;
        } else if (this.milk < coffee.getMilk()) {
            System.out.println("Sorry, not enough milk!");
            return false;
        } else if (this.beans < coffee.getBeans()) {
            System.out.println("Sorry, not enough beans!");
            return false;
        } else if (this.cups < 1) {
            System.out.println("Sorry, not enough cups!");
            return false;
        } else {
            this.water -= coffee.getWater();
            this.milk -= coffee.getMilk();
            this.beans -= coffee.getBeans();
            this.cups--;
            System.out.println("I have enough resources, making you a coffee!");
            return true;
        }
    }

    public int getWater() {
        return water;
    }

    public void addWater(String input) {
        this.water += Integer.parseInt(input);
    }

    public int getMilk() {
        return milk;
    }

    public void addMilk(String input) {
        this.milk += Integer.parseInt(input);
    }

    public int getBeans() {
        return beans;
    }

    public void addBeans(String input) {
        this.beans += Integer.parseInt(input);
    }

    public int getCups() {
        return cups;
    }

    public void addCups(String input) {
        this.cups += Integer.parseInt(input);
    }
}
