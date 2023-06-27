package machine;

public class Coffee {

    private int water;
    private int milk;
    private int beans;
    private int money;

    public Coffee(int water, int milk, int beans, int money) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.money = money;
    }

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getBeans() {
        return beans;
    }

    public int getMoney() {
        return money;
    }
}
